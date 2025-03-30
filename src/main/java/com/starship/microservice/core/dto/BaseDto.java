package com.starship.microservice.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class BaseDto implements Serializable {

    @NotBlank
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotBlank
    @JsonProperty("isDel")
    private Boolean isDel;

    @NotBlank
    @JsonProperty("createdAt")
    private Timestamp createdAt;

    @NotBlank
    @JsonProperty("updatedAt")
    private Timestamp updatedAt;

    @NotBlank
    @JsonProperty("createdBy")
    private UUID createdBy;

    @NotBlank
    @JsonProperty("updatedBy")
    private UUID updatedBy;
}
