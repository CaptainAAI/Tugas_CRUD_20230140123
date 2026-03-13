package com.crudktp.crudKTP.service;

import com.crudktp.crudKTP.model.dto.UserAddRequest;
import com.crudktp.crudKTP.model.dto.UserDto;

public interface UserService {
    UserDto AddDataWarga(UserAddRequest request);
}
