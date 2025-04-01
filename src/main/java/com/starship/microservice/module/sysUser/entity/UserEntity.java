
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
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "userID")
    private UUID userID = UUID.randomUUID();

    @NotBlank
    @Size(max = 255, message = "Username should be between 4 and 255 characters")
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max = 255, message = "Email should be between 4 and 255 characters")
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 255, message = "Password should be between 4 and 255 characters")
    @Column(name = "password")
    private String password;
}
