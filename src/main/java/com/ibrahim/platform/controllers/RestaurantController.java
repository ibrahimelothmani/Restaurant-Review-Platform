package com.ibrahim.platform.controllers;

import com.ibrahim.platform.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.ibrahim.platform.domain.dtos.RestaurantDto;
import com.ibrahim.platform.mappers.RestaurantMapper;
import com.ibrahim.platform.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/restaurants")
@RequiredArgsConstructor

public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(
            @Valid
            @RequestBody
            RestaurantCreateUpdateRequestDto request) {
        RestaurantDto restaurantDto = restaurantMapper.toRestaurantDto(restaurantService.createRestaurant(request));
        return ResponseEntity.ok(restaurantDto);
    }


}
