package com.example.cuisine.italyCuisine.ItalyCuisineEnum;

import com.example.cuisine.interfaces.dish.DishGeneral;
import com.example.cuisine.interfaces.dish.DishPrice;
import lombok.Getter;

/**
 * Italian cuisine dishes enum.
 */
public enum ItalyCuisineDishEnum implements DishPrice, DishGeneral {

    PIZZA("Pizza", 30),
    SPAGHETTI("Spaghetti", 40),
    RAVIOLI("Ravioli",45),
    RISOTTO("Risotto", 27);

    private final double italyDishPrice;

    @Getter
    private final String italyDishName;

   ItalyCuisineDishEnum(String italyDishName, double italyDishPrice) {
       this.italyDishName = italyDishName;
       this.italyDishPrice = italyDishPrice;
   }

    /**
     * Gets a dish price.
     *
     * @return dish price
     **/
    @Override
    public double getDishPrice() {
        return italyDishPrice;
    }
}
