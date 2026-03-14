package com.crudktp.crudKTP.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ktp")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nomorKtp", nullable = false, unique = true)
    private String nomorKtp;
    @Column(name = "namaLengkap", nullable = false)
    private String namaLengkap;
    @Column(name = "alamat", nullable = false)
    private String alamat;
    @Column(name = "tanggalLahir", nullable = false)
    private Date tanggalLahir;
    @Column(name = "jenisKelamin", nullable = false)
    private String jenisKelamin;


}
