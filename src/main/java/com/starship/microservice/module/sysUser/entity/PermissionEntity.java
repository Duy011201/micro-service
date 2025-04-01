
package com.starship.microservice.module.sysUser.entity;

import com.starship.microservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permissions")
public class PermissionEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "permissionID")
    private UUID permissionID = UUID.randomUUID();

    @NotBlank
    @Size(max = 255, message = "Permission name should be between 4 and 255 characters")
    @Column(name = "permissionName")
    private String permissionName;

    @NotBlank
    @Size(max = 255, message = "Permission code should be between 4 and 255 characters")
    @Column(name = "permissionCode")
    private String permissionCode;
}
