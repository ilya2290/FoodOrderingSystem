package com.example.cuisine.polandCuisine;

import com.example.cuisine.Cuisine;
import com.example.cuisine.interfaces.dessert.DessertGeneral;
import com.example.cuisine.interfaces.dish.DishGeneral;
import com.example.cuisine.interfaces.drink.DrinkGeneral;
import com.example.cuisine.polandCuisine.polandCuisineEnums.PolandCuisineDessertEnum;
import com.example.cuisine.polandCuisine.polandCuisineEnums.PolandCuisineDishEnum;
import com.example.cuisine.polandCuisine.polandCuisineEnums.PolandCuisineDrinkEnum;
import java.util.HashMap;
import java.util.Optional;

/**
 * Poland's cuisine class.
 */
public class PolandCuisine extends Cuisine {

    /**
     * Checks a dish existing.
     *
     * @param dishName The dish name
     *
     * @return Returns Optional dish name
     */
    @Override
    public Optional<DishGeneral> checkDishExisting(String dishName) {
        for (PolandCuisineDishEnum polandCuisineDishEnum : PolandCuisineDishEnum.values()) {
            if (polandCuisineDishEnum.getPolandDishName().equalsIgnoreCase(dishName)) {
                return Optional.of(polandCuisineDishEnum);
            }
        }
        return Optional.empty();
    }

    /**
     * Checks a dessert existing.
     *
     * @param desertName The dessert name
     *
     * @return Returns Optional dessert name
     */
    @Override
    public Optional<DessertGeneral> checkDessertExisting(String desertName) {
        for (PolandCuisineDessertEnum dessertNameEnum : PolandCuisineDessertEnum.values()) {
            if (dessertNameEnum.getPolandDessertName().equalsIgnoreCase(desertName)) {
                return Optional.of(dessertNameEnum);
            }
        }
        return Optional.empty();
    }

    /**
     * Checks a drink existing.
     *
     * @param drinkName The drink name
     *
     * @return Returns Optional drink name
     */
    @Override
    public Optional<DrinkGeneral> checkDrinkExisting(String drinkName) {
        for (PolandCuisineDrinkEnum alcoholDrinkEnum : PolandCuisineDrinkEnum.values()) {
            if (alcoholDrinkEnum.getPolandDrinkName().equalsIgnoreCase(drinkName)) {
                return Optional.of(alcoholDrinkEnum);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets a dessert price.
     *
     * @param dessertName The dish name
     *
     * @return Returns Optional dessert price
     */
    @Override
    public double getDessertPrice(String dessertName) {
        PolandCuisineDessertEnum polandCuisineDessertEnum;
        Optional<DessertGeneral> optionalDessert = this.checkDessertExisting(dessertName);

        if (optionalDessert.isPresent()) {
            polandCuisineDessertEnum = (PolandCuisineDessertEnum) optionalDessert.get();

            return polandCuisineDessertEnum.getDessertPrice();
        }

        System.out.println(STR."There no drink existing: \{dessertName}");
        return 0;
    }

    /**
     * Gets a drink price.
     *
     * @param drinkName The drink name
     *
     * @return Returns Optional drink price
     */
    @Override
    public double getDrinkPrice(String drinkName) {
        PolandCuisineDrinkEnum alcoholDrinkEnum;
        Optional<DrinkGeneral> optional = this.checkDrinkExisting(drinkName);

        if (optional.isPresent()) {
            alcoholDrinkEnum = (PolandCuisineDrinkEnum) optional.get();

            return alcoholDrinkEnum.getDrinkPrice();
        }
        System.out.println(STR."There no drink existing: \{drinkName}");
        return 0;
    }

    /**
     * Gets a dish price.
     *
     * @param dishName The drink name
     *
     * @return Returns Optional drink price
     */
    @Override
    public double getDishPrice(String dishName) {
        PolandCuisineDishEnum polandCuisineDishEnum;
        Optional<DishGeneral> optionalDish = this.checkDishExisting(dishName);

        if (optionalDish.isPresent()) {
            polandCuisineDishEnum = (PolandCuisineDishEnum) optionalDish.get();

            return polandCuisineDishEnum.getDishPrice();
        }

        System.out.println(STR."There no drink existing: \{dishName}");
        return 0;
    }

    /**
     * Gets cuisine all dishes.
     *
     * @return Returns cuisine all dishes
     */
    @Override
    public HashMap<String, Double> getCuisineAllDishes() {
        HashMap<String, Double> dishesPrices = new HashMap<>();

        for (PolandCuisineDishEnum polandDish : PolandCuisineDishEnum.values())
            dishesPrices.put(polandDish.getPolandDishName(), polandDish.getDishPrice());

        return dishesPrices;
    }

    /**
     * Gets cuisine all desserts.
     *
     * @return Returns cuisine all desserts
     */
    @Override
    public HashMap<String, Double> getCuisineAllDesserts() {
        HashMap<String, Double> cuisineAllDesserts = new HashMap<>();

        for (PolandCuisineDessertEnum polandDessert : PolandCuisineDessertEnum.values())
            cuisineAllDesserts.put(polandDessert.getPolandDessertName(), polandDessert.getDessertPrice());
        return cuisineAllDesserts;

    }

    /**
     * Gets cuisine all drinks
     *
     * @return Returns cuisine all drinks
     */
    @Override
    public HashMap<String, Double> getCuisineAllDrinks() {
        HashMap<String, Double> cuisineAllDrinks = new HashMap<>();

        for (PolandCuisineDrinkEnum polandDrink : PolandCuisineDrinkEnum.values())
            cuisineAllDrinks.put(polandDrink.getPolandDrinkName(), polandDrink.getDrinkPrice());

        return cuisineAllDrinks;
    }

}

