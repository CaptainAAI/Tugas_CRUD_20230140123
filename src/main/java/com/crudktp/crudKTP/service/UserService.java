package com.crudktp.crudKTP.service;

import com.crudktp.crudKTP.model.dto.UserAddRequest;
import com.crudktp.crudKTP.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto AddDataWarga(UserAddRequest request);
    List<UserDto> getAllDataWarga();
    UserDto getDataWargaById(int id);
    UserDto updateDataWarga(int id, UserAddRequest request);
    void deleteDataWarga(int id);
}
