package com.crudktp.crudKTP.service.Impl;

import com.crudktp.crudKTP.mapper.UserMapper;
import com.crudktp.crudKTP.model.dto.UserAddRequest;
import com.crudktp.crudKTP.model.dto.UserDto;
import com.crudktp.crudKTP.model.entity.User;
import com.crudktp.crudKTP.repository.UserRepository;
import com.crudktp.crudKTP.service.UserService;
import com.crudktp.crudKTP.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public UserDto AddDataWarga(UserAddRequest request) {
        validationUtil.validate(request);

        if (userRepository.existsByNomorKtp(request.getNomorKTP())) {
            throw new IllegalStateException("Nomor KTP sudah terdaftar");
        }

        User saveUser = User.builder()
                .nomorKtp(request.getNomorKTP())
                .namaLengkap(request.getNama())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        userRepository.save(saveUser);

        return toUserDto(saveUser);
    }

    @Override
    public UserDto getDataWargaById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Data Warga dengan id " + id + " tidak ditemukan"));
        return toUserDto(user);
    }

    @Override
    public List<UserDto> getAllDataWarga() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::toUserDto).toList();
    }

    @Override
    public UserDto updateDataWarga(int id, UserAddRequest request) {
        validationUtil.validate(request);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Data Warga dengan id " + id + " tidak ditemukan"));

        // Jika nomor KTP diubah, pastikan tidak bentrok dengan data lain
        if (!user.getNomorKtp().equals(request.getNomorKTP()) &&
                userRepository.existsByNomorKtp(request.getNomorKTP())) {
            throw new IllegalStateException("Nomor KTP sudah terdaftar");
        }

        user.setNomorKtp(request.getNomorKTP());
        user.setNamaLengkap(request.getNama());
        user.setAlamat(request.getAlamat());
        user.setTanggalLahir(request.getTanggalLahir());
        user.setJenisKelamin(request.getJenisKelamin());

        userRepository.save(user);

        return toUserDto(user);
    }

    @Override
    public void deleteDataWarga(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Data Warga dengan id " + id + " tidak ditemukan"));
        userRepository.delete(user);
    }

    private UserDto toUserDto(User user) {
        UserDto dto = UserMapper.MAPPER.toUserDtoData(user);
        dto.setNama(user.getNamaLengkap());
        dto.setNomorKTP(user.getNomorKtp());
        return dto;
    }
}
