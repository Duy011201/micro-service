package com.starship.microservice.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity implements Serializable {

    @NotBlank
    @Column(name = "IS_ACTIVE", nullable = false)
    Boolean isActive;

    @NotBlank
    @Column(name = "IS_DEL", nullable = false)
    Boolean isDel;

    @NotBlank
    @Column(name = "CREATED_AT", nullable = false)
    Timestamp createdAt;

    @NotBlank
    @Column(name = "UPDATED_AT", nullable = false)
    Timestamp updatedAt;

    @NotBlank
    @Column(name = "CREATED_BY", nullable = false)
    UUID createdBy;

    @NotBlank
    @Column(name = "UPDATED_BY", nullable = false)
    UUID updatedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
