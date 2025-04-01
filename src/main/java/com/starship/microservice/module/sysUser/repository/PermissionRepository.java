package com.starship.microservice.module.sysUser.repository;

import com.starship.microservice.module.sysUser.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, UUID> {
    @Query("SELECT p FROM PermissionEntity p WHERE p.permissionID = :permissionID")
    PermissionEntity findPermissionByID(@Param("permissionID") UUID permissionID);

    @Query("SELECT p FROM PermissionEntity p WHERE p.permissionCode = :permissionCode")
    PermissionEntity findPermissionByCode(@Param("permissionCode") String permissionCode);
}
