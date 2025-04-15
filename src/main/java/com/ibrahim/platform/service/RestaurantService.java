package com.ibrahim.platform.service;

import com.ibrahim.platform.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.ibrahim.platform.domain.entities.Restaurant;
import jakarta.validation.Valid;

public interface RestaurantService {

    Restaurant createRestaurant(@Valid RestaurantCreateUpdateRequestDto request);
}
