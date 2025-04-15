package com.ibrahim.platform.domain.dtos;


import com.ibrahim.platform.domain.entities.OperatingHours;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 * DTO for creating or updating a restaurant.
 * <p>
 * This class is used to transfer data between the client and server when creating or updating a restaurant.
 * It contains fields for the restaurant's name, cuisine type, contact information, address, operating hours,
 * and a list of photo IDs.
 */

public class RestaurantCreateUpdateRequestDto {

    @NotBlank(message = "Restaurant name cannot be blank")
    private String name;

    @NotBlank(message = "Cuisine cannot be blank")
    private String cuisineType;

    @NotBlank(message = "Contact information cannot be blank")
    private String contactInformation;

    @Valid
    private AddressDto address;

    @Valid
    private OperatingHoursDto operatingHours;

    @Size(min = 1, message = "At least one photo ID is required")
    private List<String> photoIds;
}
