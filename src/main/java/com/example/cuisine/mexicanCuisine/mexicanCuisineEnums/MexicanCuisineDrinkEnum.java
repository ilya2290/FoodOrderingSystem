package com.example.cuisine.mexicanCuisine.mexicanCuisineEnums;

import com.example.cuisine.interfaces.drink.DrinkGeneral;
import com.example.cuisine.interfaces.drink.DrinkPrice;
import lombok.Getter;

/**
 * Italian cuisine drinks enum.
 */
public enum MexicanCuisineDrinkEnum implements DrinkPrice, DrinkGeneral {

    MARGARITA("Margarita", 10),
    PALOMA("Paloma", 12),
    TEQUILA("Tequila",300);

    private final double mexicanDrinkPrice;
    @Getter
    private final String mexicanDrinkName;

    MexicanCuisineDrinkEnum(String mexicanDrinkName, double mexicanDrinkPrice) {
        this.mexicanDrinkName = mexicanDrinkName;
        this.mexicanDrinkPrice = mexicanDrinkPrice;
    }

    /**
     * Gets a drink price.
     *
     * @return drink price
     **/
    @Override
    public double getDrinkPrice() {
        return mexicanDrinkPrice;
    }
}
