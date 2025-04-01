package com.starship.microservice.module.sysUser.repository;

import com.starship.microservice.module.sysUser.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query("SELECT u FROM UserEntity u WHERE u.userID = :userID")
    UserEntity findUserByID(@Param("userID") UUID userID);

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity findUserByEmail(@Param("email") String email);
}
