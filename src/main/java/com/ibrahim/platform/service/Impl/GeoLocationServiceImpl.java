package com.ibrahim.platform.service.Impl;

import com.ibrahim.platform.domain.GeoLocation;
import com.ibrahim.platform.domain.dtos.AddressDto;
import com.ibrahim.platform.service.GeoLocationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;


@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    //Tunisia Location
    private static final float MIN_LATITUDE = 32.0f;
    private static final float MAX_LATITUDE = 37.5f;
    private static final float MIN_LONGITUDE = 7.0f;
    private static final float MAX_LONGITUDE = 11.5f;

    @Override
    public GeoLocation getGeoLocation(@Valid AddressDto address) {
        // Simulate a geolocation based on the address
        // In a real application, you would use a geocoding service to get the actual coordinates
        double latitude = MIN_LATITUDE + Math.random() * (MAX_LATITUDE - MIN_LATITUDE);
        double longitude = MIN_LONGITUDE + Math.random() * (MAX_LONGITUDE - MIN_LONGITUDE);

        return GeoLocation.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
