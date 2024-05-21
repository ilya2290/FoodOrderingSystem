package com.example.cuisine;

import com.example.cuisine.interfaces.dessert.DessertGeneral;
import com.example.cuisine.interfaces.dish.DishGeneral;
import com.example.cuisine.interfaces.drink.DrinkGeneral;
import java.util.HashMap;
import java.util.Optional;

/**
 * Base class for the all cuisines.
 */
public abstract class Cuisine {

    /**
     * Checks a dish existing.
     *
     * @param dishName The dish name
     */
    public abstract Optional<DishGeneral> checkDishExisting(String dishName);

    /**
     * Checks a dessert existing.
     *
     * @param desertName The dessert name
     *
     * @return Returns Optional dessert name
     */
    public abstract Optional<DessertGeneral> checkDessertExisting(String desertName);

    /**
     * Checks drink existing existing.
     *
     * @param drinkName The drink name
     */
    public abstract Optional<DrinkGeneral> checkDrinkExisting(String drinkName);

    /**
     * Gets a dessert price.
     *
     * @param dessertName The dish name
    **/
    public abstract double getDessertPrice(String dessertName);

    /**
     * Gets a dish price.
     *
     * @param dishName The dish name
     */
    public abstract double getDishPrice(String dishName);

    /**
     * Gets a drink price.
     *
     * @param drinkName The drink name
     */
    public abstract double getDrinkPrice(String drinkName);

    /**
     * Gets cuisine all dishes
     */
    public abstract HashMap<String, Double> getCuisineAllDishes();

    /**
     * Gets cuisine all desserts
     */
    public abstract HashMap<String, Double> getCuisineAllDesserts();

    /**
     * Gets cuisine all drinks
     */
    public abstract HashMap<String, Double> getCuisineAllDrinks();

}
