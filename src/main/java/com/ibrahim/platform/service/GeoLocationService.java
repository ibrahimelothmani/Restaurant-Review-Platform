package com.ibrahim.platform.service;

import com.ibrahim.platform.domain.GeoLocation;
import com.ibrahim.platform.domain.dtos.AddressDto;
import jakarta.validation.Valid;

public interface GeoLocationService {
    GeoLocation getGeoLocation(@Valid AddressDto address);
}
