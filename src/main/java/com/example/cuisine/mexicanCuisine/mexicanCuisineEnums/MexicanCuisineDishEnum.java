package com.example.cuisine.mexicanCuisine.mexicanCuisineEnums;

import com.example.cuisine.interfaces.dish.DishGeneral;
import com.example.cuisine.interfaces.dish.DishPrice;
import lombok.Getter;

/**
 * Mexican cuisine dishes enum.
 */
public enum MexicanCuisineDishEnum implements DishPrice, DishGeneral {

    BURRITO("Burrito", 10),
    ENSILADAS("Ensiladas", 15),
    QUESADILIA("Quesadilia", 20);

    private final double mexicanDishPrice;
    @Getter
    private final String mexicanDishName;

    MexicanCuisineDishEnum( String mexicanDishName, double mexicanDishPrice) {
        this.mexicanDishName = mexicanDishName;
        this.mexicanDishPrice = mexicanDishPrice;
    }

    /**
     * Gets a dish price.
     *
     * @return dish price
     **/
    @Override
    public double getDishPrice() {
        return mexicanDishPrice;
    }
}
