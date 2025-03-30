package com.starship.microservice.module.sysUser.repository;

import com.starship.microservice.module.sysUser.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    @Query("SELECT r FROM RoleEntity r WHERE r.roleID = :roleID")
    RoleEntity findRoleByID(@Param("roleID") UUID roleID);

    @Query("SELECT r FROM RoleEntity r WHERE r.roleCode = :roleCode")
    RoleEntity findRoleByCode(@Param("roleCode") String roleCode);
}
