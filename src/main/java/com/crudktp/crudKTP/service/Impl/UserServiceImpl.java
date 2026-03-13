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

        User saveUser = User.builder()
                .nomorKtp(request.getNomorKTP())
                .namaLengkap(request.getNama())
                .alamat(request.getAlamat())
                .tanggalLahir(request.getTanggalLahir())
                .jenisKelamin(request.getJenisKelamin())
                .build();

        userRepository.save(saveUser);

        return UserMapper.MAPPER.toUserDtoData(saveUser);
    }

    @Override
    public UserDto getDataWargaById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Data Warga not found"));
        return UserMapper.MAPPER.toUserDtoData(user);
    }

    @Override
    public List<UserDto> getAllDataWarga() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper.MAPPER::toUserDtoData).toList();
    }

    @Override
    public UserDto updateDataWarga(String id, UserAddRequest request) {
        validationUtil.validate(request);

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Data Warga not found"));

        user.setNomorKtp(request.getNomorKTP());
        user.setNamaLengkap(request.getNama());
        user.setAlamat(request.getAlamat());
        user.setTanggalLahir(request.getTanggalLahir());
        user.setJenisKelamin(request.getJenisKelamin());

        userRepository.save(user);

        return UserMapper.MAPPER.toUserDtoData(user);
    }

    @Override
    public void deleteDataWarga(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Data Warga not found"));
        userRepository.delete(user);
    }






}
