package com.cybersoft.demospringboot03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybersoft.demospringboot03.entity.UsersEntity;

@Repository // đánh dấu class này là repository

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    List<UsersEntity> findByFullnameAndEmail(String fullname, String email);

    UsersEntity findByEmail(String email);

}
