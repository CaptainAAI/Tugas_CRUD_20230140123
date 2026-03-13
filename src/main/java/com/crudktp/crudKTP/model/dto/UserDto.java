package com.crudktp.crudKTP.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String nomorKTP;
    private String nama;
    private String alamat;
    private String tanggalLahir;
    private String jenisKelamin;
}
