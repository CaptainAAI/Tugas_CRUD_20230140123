package com.crudktp.crudKTP.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class UserAddRequest {
    @NotBlank(message = "nomorKtp wajib diisi")
    private String nomorKtp;

    @NotBlank(message = "nama wajib diisi")
    private String nama;

    @NotBlank(message = "alamat wajib diisi")
    private String alamat;

    @NotNull(message = "tanggalLahir wajib diisi")
    private Date tanggalLahir;

    @NotBlank(message = "jenisKelamin wajib diisi")
    private String jenisKelamin;
}
