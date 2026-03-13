package com.crudktp.crudKTP.mapper;

import com.crudktp.crudKTP.model.dto.UserDto;
import com.crudktp.crudKTP.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER= Mappers.getMapper(UserMapper.class);

     UserDto toUserDtoData(User user);
}
