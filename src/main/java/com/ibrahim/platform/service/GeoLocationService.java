package com.ibrahim.platform.service;

import com.ibrahim.platform.domain.GeoLocation;
import com.ibrahim.platform.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation getGeoLocation(Address address);
}
