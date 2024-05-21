package com.example.cuisine.mexicanCuisine;

import com.example.cuisine.Cuisine;
import com.example.cuisine.interfaces.dessert.DessertGeneral;
import com.example.cuisine.interfaces.dish.DishGeneral;
import com.example.cuisine.interfaces.drink.DrinkGeneral;
import com.example.cuisine.mexicanCuisine.mexicanCuisineEnums.MexicanCuisineDessertEnum;
import com.example.cuisine.mexicanCuisine.mexicanCuisineEnums.MexicanCuisineDishEnum;
import com.example.cuisine.mexicanCuisine.mexicanCuisineEnums.MexicanCuisineDrinkEnum;
import java.util.HashMap;
import java.util.Optional;

/**
 * Mexican's cuisine class.
 */
public class MexicanCuisine extends Cuisine {

    /**
     * Checks a dish existing.
     *
     * @param dishName The dish name
     *
     * @return Returns Optional dish name
     */
    @Override
    public Optional<DishGeneral> checkDishExisting(String dishName) {
        for (MexicanCuisineDishEnum mexicanCuisineDishEnum : MexicanCuisineDishEnum.values()) {
            if (mexicanCuisineDishEnum.getMexicanDishName().equalsIgnoreCase(dishName)) {
                return Optional.of(mexicanCuisineDishEnum);
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
        for (MexicanCuisineDessertEnum dessertNameEnum : MexicanCuisineDessertEnum.values()) {
            if (dessertNameEnum.getMexicanDessertName().equalsIgnoreCase(desertName)) {
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
        for (MexicanCuisineDrinkEnum alcoholDrinkEnum : MexicanCuisineDrinkEnum.values()) {
            if (alcoholDrinkEnum.getMexicanDrinkName().equalsIgnoreCase(drinkName)) {
                return Optional.of(alcoholDrinkEnum);
            }
        }

        return Optional.empty();
    }

    /**
     * Get a dessert price.
     *
     * @param dessertName The dish name
     *
     * @return Returns Optional dessert price
     */
    @Override
    public double getDessertPrice(String dessertName) {
        MexicanCuisineDessertEnum mexicanCuisineDessertEnum;
        Optional<DessertGeneral> optionalDessert = this.checkDessertExisting(dessertName);

        if (optionalDessert.isPresent()) {
            mexicanCuisineDessertEnum = (MexicanCuisineDessertEnum) optionalDessert.get();

            return mexicanCuisineDessertEnum.getDessertPrice();
        }

        System.out.println(STR."There no drink existing: \{dessertName}");
        return 0;
    }

    /**
     * Get a drink price.
     *
     * @param drinkName The drink name
     *
     * @return Returns Optional drink price
     */
    @Override
    public double getDrinkPrice(String drinkName) {
        MexicanCuisineDrinkEnum alcoholDrinkEnum;
        Optional<DrinkGeneral> optional = this.checkDrinkExisting(drinkName);

        if (optional.isPresent()) {
            alcoholDrinkEnum = (MexicanCuisineDrinkEnum) optional.get();

            return alcoholDrinkEnum.getDrinkPrice();
        }
        System.out.println(STR."There no drink existing: \{drinkName}");
        return 0;
    }

    /**
     * Get a dish price.
     *
     * @param dishName The dish name
     *
     * @return Returns Optional dish price
     */
    @Override
    public double getDishPrice(String dishName) {
        MexicanCuisineDishEnum mexicanCuisineDishEnum;
        Optional<DishGeneral> optionalDish = this.checkDishExisting(dishName);

        if (optionalDish.isPresent()) {
            mexicanCuisineDishEnum = (MexicanCuisineDishEnum) optionalDish.get();

            return mexicanCuisineDishEnum.getDishPrice();
        }

        System.out.println(STR."There no drink existing: \{dishName}");
        return 0;
    }

    /**
     * Get cuisine all dishes.
     *
     * @return Returns cuisine all dishes
     */
    @Override
    public HashMap<String, Double> getCuisineAllDishes() {
        HashMap<String, Double> dishesPrices = new HashMap<>();

        for (MexicanCuisineDishEnum mexicanDish : MexicanCuisineDishEnum.values())
            dishesPrices.put(mexicanDish.getMexicanDishName(), mexicanDish.getDishPrice());

        return dishesPrices;
    }

    /**
     * Get cuisine all desserts.
     *
     * @return Returns cuisine all desserts
     */
    @Override
    public HashMap<String, Double> getCuisineAllDesserts() {
        HashMap<String, Double> cuisineAllDesserts = new HashMap<>();

        for (MexicanCuisineDessertEnum mexicanDessert : MexicanCuisineDessertEnum.values())
            cuisineAllDesserts.put(mexicanDessert.getMexicanDessertName(), mexicanDessert.getDessertPrice());

        return cuisineAllDesserts;
    }

    /**
     * Get cuisine all drinks
     *
     * @return Returns cuisine all drinks
     */
    @Override
    public HashMap<String, Double> getCuisineAllDrinks() {
        HashMap<String, Double> cuisineAllDrinks = new HashMap<>();

        for (MexicanCuisineDrinkEnum mexicanDrink : MexicanCuisineDrinkEnum.values())
            cuisineAllDrinks.put(mexicanDrink.getMexicanDrinkName(), mexicanDrink.getDrinkPrice());

        return cuisineAllDrinks;
    }

}
