package com.crudktp.crudKTP.mapper;

import com.crudktp.crudKTP.model.dto.UserDto;
import com.crudktp.crudKTP.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "nomorKtp", source = "nomorKtp")
    @Mapping(target = "nama", source = "namaLengkap")
    @Mapping(target = "alamat", source = "alamat")
    @Mapping(target = "tanggalLahir", source = "tanggalLahir")
    @Mapping(target = "jenisKelamin", source = "jenisKelamin")
    UserDto toUserDtoData(User user);
}
