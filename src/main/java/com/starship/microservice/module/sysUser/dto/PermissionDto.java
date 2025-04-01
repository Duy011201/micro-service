
package com.starship.microservice.module.sysUser.dto;

import com.starship.microservice.core.dto.BaseDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDto extends BaseDto {

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
