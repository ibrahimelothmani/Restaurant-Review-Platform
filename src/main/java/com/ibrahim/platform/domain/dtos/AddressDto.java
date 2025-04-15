package com.ibrahim.platform.domain.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AddressDto {

    @NotBlank(message = "Street Number is required")
    @Pattern(regexp = "^[0-9]{1,5}[a-zA-Z]?$", message = "Street Number must be a number")
    private String streetNumber;

    @NotBlank(message = "Unit is required")
    private String unit;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Postal Code is required")
    private String postalCode;

    @NotBlank(message = "Street Name is required")
    private String streetName;


}
