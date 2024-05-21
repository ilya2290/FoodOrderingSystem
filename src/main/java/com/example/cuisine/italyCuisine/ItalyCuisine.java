package com.example.cuisine.italyCuisine;

import com.example.cuisine.Cuisine;
import com.example.cuisine.interfaces.dessert.DessertGeneral;
import com.example.cuisine.interfaces.dish.DishGeneral;
import com.example.cuisine.interfaces.drink.DrinkGeneral;
import com.example.cuisine.italyCuisine.ItalyCuisineEnum.ItalyCuisineDrinkEnum;
import com.example.cuisine.italyCuisine.ItalyCuisineEnum.ItalyCuisineDessertEnum;
import com.example.cuisine.italyCuisine.ItalyCuisineEnum.ItalyCuisineDishEnum;
import java.util.HashMap;
import java.util.Optional;

/**
 * Italy's cuisine class.
 */
public class ItalyCuisine extends Cuisine {

    /**
     * Checks a dish existing.
     *
     * @param dishName The dish name
     *
     * @return Returns Optional dish name
     */
    @Override
    public Optional<DishGeneral> checkDishExisting(String dishName) {

        for (ItalyCuisineDishEnum dessertNameEnum : ItalyCuisineDishEnum.values()) {
            if (dessertNameEnum.getItalyDishName().equalsIgnoreCase(dishName)) {
                return Optional.of(dessertNameEnum);
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

        for (ItalyCuisineDessertEnum dessertNameEnum : ItalyCuisineDessertEnum.values()) {
            if (dessertNameEnum.getItalyDessertName().equalsIgnoreCase(desertName)) {
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
        for (ItalyCuisineDrinkEnum alcoholDrinkEnum : ItalyCuisineDrinkEnum.values()) {
            if (alcoholDrinkEnum.getItalyAlcoholDrinkName().equalsIgnoreCase(drinkName)) {
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
        ItalyCuisineDessertEnum italyCuisineDessertEnum;
        Optional<DessertGeneral> optionalDessert = this.checkDessertExisting(dessertName);

        if (optionalDessert.isPresent()) {
            italyCuisineDessertEnum = (ItalyCuisineDessertEnum) optionalDessert.get();

            return italyCuisineDessertEnum.getDessertPrice();
        }
        return 0;
    }

    /**
     * Gets a drink price.
     *
     * @param dishName The drink name
     *
     * @return Returns Optional drink price
     */
    @Override
    public double getDishPrice(String dishName) {
        ItalyCuisineDishEnum italyCuisineDishEnum;
        Optional<DishGeneral> optionalDish = this.checkDishExisting(dishName);

        if (optionalDish.isPresent()) {
            italyCuisineDishEnum = (ItalyCuisineDishEnum) optionalDish.get();

            return italyCuisineDishEnum.getDishPrice();
        }
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
        ItalyCuisineDrinkEnum alcoholDrinkEnum;
        Optional<DrinkGeneral> optional = this.checkDrinkExisting(drinkName);

        if (optional.isPresent()) {
            alcoholDrinkEnum = (ItalyCuisineDrinkEnum) optional.get();

            return alcoholDrinkEnum.getDrinkPrice();
        }
        return 0;
    }

    /**
     * Gets cuisine all dishes.
     *
     * @return Returns cuisine all dishes
     */
    @Override
    public HashMap<String, Double> getCuisineAllDishes() {
        HashMap<String, Double> cuisineAllDishes = new HashMap<>();

        for (ItalyCuisineDishEnum italyDish : ItalyCuisineDishEnum.values())
            cuisineAllDishes.put(italyDish.getItalyDishName(), italyDish.getDishPrice());

        return cuisineAllDishes;
    }

    /**
     * Gets cuisine all desserts.
     *
     * @return Returns cuisine all desserts
     */
    @Override
    public HashMap<String, Double> getCuisineAllDesserts() {
        HashMap<String, Double> cuisineAllDesserts = new HashMap<>();

        for (ItalyCuisineDessertEnum italyDessert : ItalyCuisineDessertEnum.values())
            cuisineAllDesserts.put(italyDessert.getItalyDessertName(), italyDessert.getDessertPrice());

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

        for (ItalyCuisineDrinkEnum italyDrink : ItalyCuisineDrinkEnum.values())
            cuisineAllDrinks.put(italyDrink.getItalyAlcoholDrinkName(), italyDrink.getDrinkPrice());

        return cuisineAllDrinks;
    }

}
