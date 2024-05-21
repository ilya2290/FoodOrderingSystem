package com.example.cuisine.mexicanCuisine.mexicanCuisineEnums;

import com.example.cuisine.interfaces.dessert.DessertGeneral;
import com.example.cuisine.interfaces.dessert.DessertPrice;
import lombok.Getter;

/**
 * Mexican cuisine desserts enum.
 */
public enum MexicanCuisineDessertEnum implements DessertPrice, DessertGeneral {

    CHURROS("Churros", 12),
    FLAN("Flan", 4),
    TRESLECHES("Tresleches", 17);

    private final double mexicanDessertPrice;
    @Getter
    private final String mexicanDessertName;

    MexicanCuisineDessertEnum(String mexicanDessertName, double mexicanDessertPrice) {
        this.mexicanDessertName = mexicanDessertName;
        this.mexicanDessertPrice = mexicanDessertPrice;
    }

    /**
     * Gets a dessert price.
     *
     * @return dessert price
     **/
    @Override
    public double getDessertPrice() {
        return mexicanDessertPrice;
    }
}
