package com.crudktp.crudKTP.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserAddRequest {
    private String nomorKTP;
    private String nama;
    private String alamat;
    private Date tanggalLahir;
    private String jenisKelamin;
}
