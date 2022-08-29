package com.pacocode.carstore.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CarDto {
    @NotBlank
    private String make;
    @NotBlank
    private String model;
    @NotBlank
    private String type;
}
