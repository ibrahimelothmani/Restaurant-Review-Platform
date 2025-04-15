package com.ibrahim.platform.mappers;


import com.ibrahim.platform.domain.RestaurantCreateUpdateRequest;
import com.ibrahim.platform.domain.dtos.GeoPointDto;
import com.ibrahim.platform.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.ibrahim.platform.domain.dtos.RestaurantDto;
import com.ibrahim.platform.domain.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface RestaurantMapper {

    RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto);
    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(target = "latitude", expression = "java(geoPoint.getLat())")
    @Mapping(target = "longitude", expression = "java(geoPoint.getLon())")
    GeoPointDto toGeoPointDto(GeoPoint geoPoint);

}
