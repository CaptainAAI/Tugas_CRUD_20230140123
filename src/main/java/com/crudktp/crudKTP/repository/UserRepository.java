package com.crudktp.crudKTP.repository;

import com.crudktp.crudKTP.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByNomorKtp(String nomorKtp);
}
