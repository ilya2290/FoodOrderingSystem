package com.example.cuisine.polandCuisine.polandCuisineEnums;

import com.example.cuisine.interfaces.dessert.DessertGeneral;
import com.example.cuisine.interfaces.dessert.DessertPrice;
import lombok.Getter;

/**
 * Poland's cuisine dishes enum.
 */
public enum PolandCuisineDessertEnum implements DessertPrice, DessertGeneral {
    ANDRUT("Andrut", 5),
    KOLACZKI("Kolaczki", 7.50),
    SZARLOTKA("Szarlotka",20);

    private final double polandDessertPrice;
    @Getter
    private final String polandDessertName;

    PolandCuisineDessertEnum(String polandDessertName, double polandDessertPrice) {
        this.polandDessertName = polandDessertName;
        this.polandDessertPrice = polandDessertPrice;
    }

    /**
     * Gets a dish price.
     *
     * @return dish price
     **/
    @Override
    public double getDessertPrice() {
        return polandDessertPrice;
    }
}
