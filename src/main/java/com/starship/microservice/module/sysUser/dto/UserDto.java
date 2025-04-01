
package com.starship.microservice.module.sysUser.dto;

import com.starship.microservice.core.dto.BaseDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static com.starship.microservice.core.config.SystemConfig.REX_EMAIL;
import static com.starship.microservice.core.config.SystemConfig.REX_PASSWORD;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {

    @Id
    @GeneratedValue
    @Column(name = "userID")
    private UUID userID = UUID.randomUUID();

    @NotBlank
    @Size(max = 255, message = "Username should be between 4 and 255 characters")
    @Column(name = "username")
    private String username;

    @NotBlank
    @Pattern(regexp = REX_EMAIL, message = "Email should be valid")
    @Size(max = 255, message = "Email should be between 4 and 255 characters")
    @Column(name = "email")
    private String email;

    @NotBlank
    @Pattern(regexp = REX_PASSWORD, message = "Password should be valid")
    @Size(max = 255, message = "Password should be between 4 and 255 characters")
    @Column(name = "password")
    private String password;

    private Set<RoleDto> listRole = new HashSet<>();
}
