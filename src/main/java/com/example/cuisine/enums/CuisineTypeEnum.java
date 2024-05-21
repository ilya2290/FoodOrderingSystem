package com.example.cuisine.enums;

import lombok.Getter;

/**
 * Cuisine type enum class.
 */
@Getter
public enum CuisineTypeEnum {

    ITALY_CUISINE("Italy Cuisine"),
    MEXICAN_CUISINE("Mexican Cuisine"),
    POLAND_CUISINE("Poland Cuisine");


    private final String cuisineType;

    CuisineTypeEnum(String cuisineType) {
        this.cuisineType = cuisineType;
    }

}
