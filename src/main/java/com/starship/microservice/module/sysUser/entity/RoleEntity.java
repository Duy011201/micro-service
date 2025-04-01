
package com.starship.microservice.module.sysUser.entity;

import com.starship.microservice.core.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "roleID")
    private UUID roleID = UUID.randomUUID();

    @NotBlank
    @Size(max = 255, message = "Role name should be between 4 and 255 characters")
    @Column(name = "roleName")
    private String roleName;

    @NotBlank
    @Size(max = 255, message = "Role code should be between 4 and 255 characters")
    @Column(name = "roleCode")
    private String roleCode;

    @NotBlank
    @Size(max = 255, message = "Description should be between 4 and 255 characters")
    @Column(name = "description")
    private String description;
}
