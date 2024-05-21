package com.example.cuisine.polandCuisine.polandCuisineEnums;

import com.example.cuisine.interfaces.drink.DrinkGeneral;
import com.example.cuisine.interfaces.drink.DrinkPrice;
import lombok.Getter;

/**
 * Poland cuisine drinks enum.
 */
public enum PolandCuisineDrinkEnum  implements DrinkPrice, DrinkGeneral {

    BALTIC_PORTER("Baltic Porter", 2.85),
    GOLDWASSER("Goldwasser", 200),
    KRUPNIK("Krupnik", 60);

    private final double polandDrinkPrice;
    @Getter
    private final String polandDrinkName;

    PolandCuisineDrinkEnum(String polandDrinkName, double polandDrinkPrice) {
        this.polandDrinkName = polandDrinkName;
        this.polandDrinkPrice = polandDrinkPrice;
    }

    /**
     * Gets a drink price.
     *
     * @return drink price
     **/
    @Override
    public double getDrinkPrice() {
        return polandDrinkPrice;
    }
}
