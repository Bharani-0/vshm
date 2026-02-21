package com.vshm.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ServiceRecordDto {
    @NotNull
    private LocalDate serviceDate;
    @NotBlank
    private String serviceType;
    @NotNull
    @DecimalMin("0")
    private BigDecimal cost;
    @NotBlank
    private String serviceCenter;
    private String notes;
    @NotNull
    private LocalDate nextServiceDate;
}
