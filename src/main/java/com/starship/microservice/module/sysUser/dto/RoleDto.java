package com.starship.microservice.module.sysUser.dto;

import com.starship.microservice.core.dto.BaseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto extends BaseDto {

    @Id
    @Column(name = "roleID", nullable = false)
    private Long roleID;

    @NotBlank
    @Size(max = 255, message = "Role name should be between 4 and 255 characters")
    @Column(name = "roleName")
    private String roleName;

    @NotBlank
    @Column(name = "roleCode")
    @Size(max = 255, message = "Role code should be between 4 and 255 characters")
    private String roleCode;
}
