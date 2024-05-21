package com.example.cuisine.italyCuisine.ItalyCuisineEnum;

import com.example.cuisine.interfaces.drink.DrinkGeneral;
import com.example.cuisine.interfaces.drink.DrinkPrice;
import lombok.Getter;

/**
 * Italian cuisine drinks enum.
 */
public enum ItalyCuisineDrinkEnum implements DrinkPrice, DrinkGeneral {

    BEER("Beer", 5.50),
    WINE("Wine", 30),
    WHISKEY("Whiskey", 100);


    @Getter
    private final String italyAlcoholDrinkName;
    private final double italyDrinkPrice;

    ItalyCuisineDrinkEnum(String italyAlcoholDrinkName, double italyDrinkPrice) {
        this.italyAlcoholDrinkName = italyAlcoholDrinkName;
        this.italyDrinkPrice = italyDrinkPrice;
    }

    /**
     * Gets a drink price.
     *
     * @return drink price
     **/
    @Override
    public double getDrinkPrice() {
        return italyDrinkPrice;
    }
}
