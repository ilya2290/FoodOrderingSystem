package com.example.cuisine.italyCuisine.ItalyCuisineEnum;

import com.example.cuisine.interfaces.dessert.DessertGeneral;
import com.example.cuisine.interfaces.dessert.DessertPrice;
import lombok.Getter;

/**
 * Italian cuisine desserts enum.
 */
public enum ItalyCuisineDessertEnum implements DessertPrice, DessertGeneral {

    CANNOLI("Cannoli", 10),
    GELATO("Gelato", 9),
    TIRAMISU("Tiramisu", 13);


    private final double italyDessertPrice;
    @Getter
    private final String italyDessertName;


    ItalyCuisineDessertEnum(String italyDessertName, double italyDessertPrice) {
        this.italyDessertName = italyDessertName;
        this.italyDessertPrice = italyDessertPrice;
    }

    /**
     * Gets a dessert price.
     *
     * @return dessert price
     **/
    @Override
    public double getDessertPrice() {
        return italyDessertPrice;
    }
}
