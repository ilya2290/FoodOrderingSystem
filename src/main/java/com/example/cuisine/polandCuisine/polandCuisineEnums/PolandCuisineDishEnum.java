package com.example.cuisine.polandCuisine.polandCuisineEnums;

import com.example.cuisine.interfaces.dish.DishGeneral;
import com.example.cuisine.interfaces.dish.DishPrice;
import lombok.Getter;

/**
 * Poland's cuisine dishes enum.
 */
public enum PolandCuisineDishEnum implements DishPrice, DishGeneral {
    ZUREK("Zurek", 20),
    SUROWKA("Surowka", 30),
    CZERNINA("Czernina", 40);

    private final double polandDishPrice;
    @Getter
    private final String polandDishName;

    PolandCuisineDishEnum( String polandDishName, double polandDishPrice) {
        this.polandDishName = polandDishName;
        this.polandDishPrice = polandDishPrice;
    }

    /**
     * Gets a dish price.
     *
     * @return dish price
     **/
    @Override
    public double getDishPrice() {
        return polandDishPrice;
    }
}
