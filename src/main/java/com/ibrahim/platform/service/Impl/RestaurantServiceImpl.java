package com.ibrahim.platform.service.Impl;

import com.ibrahim.platform.domain.GeoLocation;
import com.ibrahim.platform.domain.dtos.AddressDto;
import com.ibrahim.platform.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.ibrahim.platform.domain.entities.Address;
import com.ibrahim.platform.domain.entities.Photo;
import com.ibrahim.platform.domain.entities.Restaurant;
import com.ibrahim.platform.repositories.RestaurantRepository;
import com.ibrahim.platform.service.GeoLocationService;
import com.ibrahim.platform.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final GeoLocationService geoLocationService;

    @Override
    public Restaurant createRestaurant(@Valid RestaurantCreateUpdateRequestDto request) {

        @Valid AddressDto address = request.getAddress();
        GeoLocation geoLocation = geoLocationService.getGeoLocation(address);
        GeoPoint geoPoint = new GeoPoint(geoLocation.getLatitude(), geoLocation.getLongitude());


        List<String> photoIds = request.getPhotoIds();
        List<Photo> photos = photoIds.stream()
                .map(photoUrl -> Photo.builder()
                        .url(photoUrl)
                        .uploadDate(LocalDateTime.now())
                        .build())
                .toList();

        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .cuisineType(request.getCuisineType())
                .contactInformation(request.getContactInformation())
                .geoLocation(geoPoint)
                .address(address)
                .operatingHours(request.getOperatingHours())
                .averageRating(0f)
                .build();

        return restaurantRepository.save(restaurant);
    }

}
