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
}
