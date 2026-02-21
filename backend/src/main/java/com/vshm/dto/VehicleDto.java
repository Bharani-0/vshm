package com.vshm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleDto {
    @NotBlank
    private String vehicleName;
    @NotBlank
    private String model;
    @NotBlank
    private String registrationNumber;
    @NotNull
    private LocalDate purchaseDate;
    @NotBlank
    private String fuelType;
}
