package com.ibrahim.platform.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 * A class representing a geographical location with latitude and longitude.
 */
public class GeoLocation {

    private Double latitude, longitude;
}
