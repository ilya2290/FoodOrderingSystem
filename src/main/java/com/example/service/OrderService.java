package com.example.service;

import com.example.cuisine.enums.CuisineTypeEnum;
import com.example.cuisine.italyCuisine.ItalyCuisine;
import com.example.cuisine.mexicanCuisine.MexicanCuisine;
import com.example.cuisine.polandCuisine.PolandCuisine;
import com.example.dto.OrderDTO;
import com.example.order.Order;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for the FoodOrderingController.
 */
@Service
public class OrderService {
    boolean isDish;
    boolean isDessert;
    boolean isDrinkEnable;
    boolean isIceEnable;
    boolean isLemonEnable;
    boolean isLunchEnable;
    double totalAmount;
    boolean fullMenuOrdered;
    boolean onlyLunchOrdered;
    boolean onlyDrinkOrdered;
    private OrderDTO orderDTO;
    private final ItalyCuisine italyCuisine = new ItalyCuisine();
    private final PolandCuisine polandCuisine = new PolandCuisine();
    private final MexicanCuisine mexicanCuisine = new MexicanCuisine();

    /**
     * Calculates total amount of the order.
     */
    public void calculateTotalAmount() {
        double totalAmount = 0;

        double dishPrice = this.validateDishPrice(this.orderDTO);
        double drinkPrice = this.validateDrinkPrice(this.orderDTO);
        double dessertPrice = this.validateDessertPrice(this.orderDTO);

        totalAmount = dishPrice + drinkPrice + dessertPrice;

        this.totalAmount = totalAmount;
    }

    /**
     * Checks incoming cuisine exists.
     *
     * @param cuisineType The cuisine type.
     * @return CuisineTypeEnum enum.
     */
    public CuisineTypeEnum checkCuisineExisting(String cuisineType) {

        for (CuisineTypeEnum enumValue : CuisineTypeEnum.values()) {
            if (cuisineType.equalsIgnoreCase(enumValue.getCuisineType())) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException(STR."Invalid cuisine type: \{cuisineType}");
    }

    /**
     * Gets all cuisines.
     *
     * @return result The collection with all cuisines.
     */
    public List<String> getAllCuisines() {
       return  Arrays.stream(CuisineTypeEnum.values())
                .map(CuisineTypeEnum::getCuisineType)
                .collect(Collectors.toList());
    }

        /**
         * Gets all cuisine desserts.
         *
         * @param cuisineType The cuisine type.
         * @return result Map where dessert as a Key, price as Value
         */
    public HashMap<String, Double> getAllCuisineDesserts(String cuisineType) {
        CuisineTypeEnum cuisine = this.checkCuisineExisting(cuisineType);

        return switch (cuisine) {
            case ITALY_CUISINE -> this.italyCuisine.getCuisineAllDesserts();
            case MEXICAN_CUISINE -> this.mexicanCuisine.getCuisineAllDesserts();
            case POLAND_CUISINE -> this.polandCuisine.getCuisineAllDesserts();
        };
    }

    /**
     * Gets all cuisine dishes.
     *
     * @param cuisineType The cuisine type.
     * @return result Map where cuisine as a Key, price as Value
     */
    public HashMap<String, Double> getAllCuisineDishes(String cuisineType) {
        CuisineTypeEnum cuisine = this.checkCuisineExisting(cuisineType);

        return switch (cuisine) {
            case ITALY_CUISINE -> this.italyCuisine.getCuisineAllDishes();
            case MEXICAN_CUISINE -> this.mexicanCuisine.getCuisineAllDishes();
            case POLAND_CUISINE -> this.polandCuisine.getCuisineAllDishes();
        };
    }

    /**
     * Gets all cuisine drinks.
     *
     * @param cuisineType The cuisine type.
     * @return result Map where drink as a Key, price as Value
     */
    public HashMap<String, Double> getAllCuisineDrinks(String cuisineType) {
        CuisineTypeEnum cuisine = this.checkCuisineExisting(cuisineType);

        return switch (cuisine) {
            case ITALY_CUISINE -> this.italyCuisine.getCuisineAllDrinks();
            case MEXICAN_CUISINE -> this.mexicanCuisine.getCuisineAllDrinks();
            case POLAND_CUISINE -> this.polandCuisine.getCuisineAllDrinks();
        };
    }

    /**
     * Returns special cuisine dessert price.
     *
     * @param cuisineType The cuisine type.
     * @param dessertName The dessert name
     * @return The dessert price
     */
    public double getDessertPriceByCuisine(String cuisineType, String dessertName) {
        CuisineTypeEnum cuisine = this.checkCuisineExisting(cuisineType);

        return switch (cuisine) {
            case ITALY_CUISINE -> this.italyCuisine.getDessertPrice(dessertName);
            case MEXICAN_CUISINE -> this.mexicanCuisine.getDessertPrice(dessertName);
            case POLAND_CUISINE -> this.polandCuisine.getDessertPrice(dessertName);
        };
    }

    /**
     * Returns special cuisine dish price.
     *
     * @param cuisineType The cuisine type.
     * @param dishName    The dish name
     * @return The dessert price
     */
    public double getDishPriceByCuisine(String cuisineType, String dishName) {
        CuisineTypeEnum cuisine = this.checkCuisineExisting(cuisineType);

        return switch (cuisine) {
            case ITALY_CUISINE -> this.italyCuisine.getDishPrice(dishName);
            case MEXICAN_CUISINE -> this.mexicanCuisine.getDishPrice(dishName);
            case POLAND_CUISINE -> this.polandCuisine.getDishPrice(dishName);
        };
    }

    /**
     * Returns special cuisine drink price.
     *
     * @param cuisineType The cuisine type.
     * @param drinkName   The drink name
     * @return The dessert price
     */
    public double getDrinkPriceByCuisine(String cuisineType, String drinkName) {
        CuisineTypeEnum cuisine = this.checkCuisineExisting(cuisineType);

        return switch (cuisine) {
            case ITALY_CUISINE -> this.italyCuisine.getDrinkPrice(drinkName);
            case MEXICAN_CUISINE -> this.mexicanCuisine.getDrinkPrice(drinkName);
            case POLAND_CUISINE -> this.polandCuisine.getDrinkPrice(drinkName);
        };
    }

    /**
     * Returns invalid cuisine message.
     *
     * @return The invalid cuisine message
     */
    public StringBuilder invalidCuisineMessage() {

        return new StringBuilder("Wrong cuisine type! Please make sure that you have wrote a correct cuisine.");
    }

    /**
     * Returns invalid order message.
     *
     * @return The invalid order message
     */
    public StringBuilder invalidOrderMessage() {

        return new StringBuilder()
                .append("Some fields in the order have filled incorrectly or have missed. ")
                .append("Please make sure that you have filled the all fields correctly!");
    }

    /**
     * Validates order content:
     * <ul>
     *     <li>Full menu</li>
     *     <li>Only Lunch</li>
     *     <li>Only Drink</li>
     * </ul>
     *
     * @param order The order instance.
     * @return The state: True - order is correct, False - incorrect.
     */
    public boolean validateOrderContent(Order order) {
        this.orderDTO = this.getOrderDTO(order);

        this.storeOrderResults();

        fullMenuOrdered = this.checkFullMenu();
        onlyLunchOrdered = this.isOnlyLunchOrdered();
        onlyDrinkOrdered = this.isOnlyDrinkOrdered();

        if (fullMenuOrdered)
            return true;

        else if (onlyLunchOrdered)
            return true;

        return onlyDrinkOrdered;
    }

    /**
     * Prepare order recipe.
     *
     * @return The order recipe
     */
    public StringBuilder prepareRecipe() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(STR."Cuisine: \{this.orderDTO.getCuisine()}").append('\n');

        if (this.fullMenuOrdered)
            stringBuilder.append(this.appendFullMenuToRecipe());

        else if (onlyLunchOrdered)
            stringBuilder.append(this.appendLunchToRecipe());

        else if (this.onlyDrinkOrdered)
            stringBuilder.append(this.appendOnlyDrinkToRecipe());

        stringBuilder.append('\n').append(STR."Recipe price: \{totalAmount}");

        return stringBuilder;
    }

    /**
     * Checks a current cuisine type from DTO.
     *
     * @return the current cuisine type.
     */
    private String checkCurrentCuisine() {
        return this.orderDTO.getCuisine();
    }

    /**
     * Checks is full menu ordered.
     *
     * @return TRUE - full menu, FALSE - not.
     */
    private boolean checkFullMenu() {
        return isLunchEnable && isDrinkEnable;
    }

    /**
     * Checks is garnish disabled .
     *
     * @return TRUE - garnish disable, FALSE - not.
     */
    private boolean checkGarnishDisabled() {
        return !this.isIceEnable && !this.isLemonEnable;
    }

    /**
     * Checks is it only Dessert ordered.
     *
     * @return The state: True - Dessert is ordered, False - not.
     */
    private boolean checkOnlyDessert() {
        String dessertName = this.orderDTO.getDessert();

        CuisineTypeEnum cuisine = this.checkCuisineExisting(this.checkCurrentCuisine());

        switch (cuisine) {
            case ITALY_CUISINE -> {
                return this.italyCuisine.checkDessertExisting(dessertName).isPresent();
            }
            case MEXICAN_CUISINE -> {
                return this.mexicanCuisine.checkDessertExisting(dessertName).isPresent();
            }
            case POLAND_CUISINE -> {
                return this.polandCuisine.checkDessertExisting(dessertName).isPresent();
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Checks is it only Dish ordered.
     *
     * @return The state: True - Dish is ordered, False - not.
     */
    private boolean checkOnlyDish() {
        String dishName = this.orderDTO.getMainDish();

        CuisineTypeEnum cuisine = this.checkCuisineExisting(this.checkCurrentCuisine());

        switch (cuisine) {
            case ITALY_CUISINE -> {
                return this.italyCuisine.checkDishExisting(dishName).isPresent();
            }
            case MEXICAN_CUISINE -> {
                return this.mexicanCuisine.checkDishExisting(dishName).isPresent();
            }
            case POLAND_CUISINE -> {
                return this.polandCuisine.checkDishExisting(dishName).isPresent();
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Checks is it only Drink ordered.
     *
     * @return The state: True - Drink is ordered, False - not.
     */
    private boolean checkOnlyDrink() {
        String drinkName = this.orderDTO.getDrink();
        CuisineTypeEnum cuisine = this.checkCuisineExisting(this.checkCurrentCuisine());

        switch (cuisine) {
            case ITALY_CUISINE -> {
                return this.italyCuisine.checkDrinkExisting(drinkName).isPresent();
            }
            case MEXICAN_CUISINE -> {
                return this.mexicanCuisine.checkDrinkExisting(drinkName).isPresent();
            }
            case POLAND_CUISINE -> {
                return this.polandCuisine.checkDrinkExisting(drinkName).isPresent();
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Checks is it only Lunch ordered.
     *
     * @return The state: True - Lunch is ordered, False - not.
     */
    private boolean checkOnlyLunch() {
        this.isDish = this.checkOnlyDish();
        this.isDessert = this.checkOnlyDessert();

        return isDish && isDessert;
    }

    /**
     * Returns a dish price.
     *
     * @param orderDTO The OrderDTO instance
     * @return The dish price
     */
    private double validateDishPrice(OrderDTO orderDTO) {
        double dishPrice = this.getDishPriceByCuisine(orderDTO.getCuisine(), orderDTO.getMainDish());

        if (dishPrice <= 0)
            return 0;

        return dishPrice;
    }

    /**
     * Returns a dessert price.
     *
     * @param orderDTO The OrderDTO instance
     * @return The dessert price
     */
    private double validateDessertPrice(OrderDTO orderDTO) {
        double dessertPrice = this.getDessertPriceByCuisine(orderDTO.getCuisine(), orderDTO.getDessert());

        if (dessertPrice <= 0)
            return 0;

        return dessertPrice;
    }

    /**
     * Returns a drink price.
     *
     * @param orderDTO The OrderDTO instance
     * @return The drink price
     */
    private double validateDrinkPrice(OrderDTO orderDTO) {
        double drinkPrice = this.getDrinkPriceByCuisine(orderDTO.getCuisine(), orderDTO.getDrink());

        if (drinkPrice <= 0)
            return 0;

        return drinkPrice;
    }

    /**
     * Checks is only drink ordered.
     *
     * @return TRUE - only drink ordered, FALSE - not.
     */
    private boolean isOnlyDrinkOrdered() {
        return !isDish && !isDessert && isDrinkEnable;
    }

    /**
     * Checks is only lunch ordered.
     *
     * @return TRUE - only lunch ordered, FALSE - not.
     */
    private boolean isOnlyLunchOrdered() {
        return this.isLunchEnable && !this.isDrinkEnable && this.checkGarnishDisabled();
    }

    /**
     * Checks is lemon included in the order.
     *
     * @return TRUE - lemon included, FALSE - not.
     */
    private boolean isLemonIncluded() {
        return orderDTO.isLemon();
    }

    /**
     * Checks is ice included in the order.
     *
     * @return TRUE - ice included, FALSE - not.
     */
    private boolean checkIceIncluded() {
        return orderDTO.isIce();
    }

    /**
     * Stores the orders result.
     */
    private void storeOrderResults() {
        this.isDrinkEnable = this.checkOnlyDrink();
        this.isIceEnable = this.checkIceIncluded();
        this.isLemonEnable = this.isLemonIncluded();
        this.isLunchEnable = this.checkOnlyLunch();
    }

    /**
     * Appends to the recipe Drink name and price.
     *
     * @return StringBuilder instance
     */
    private StringBuilder appendOnlyDrinkToRecipe() {
        return new StringBuilder().append("Drink: ").append(this.orderDTO.getDrink()).append("  ").append(this.validateDrinkPrice(this.orderDTO))
                .append('\n')
                .append(this.orderDTO.isLemon() ? "Lemon have added" + ('\n') : "")
                .append(this.orderDTO.isIce() ? "Ice have added " + ('\n') : "");
    }

    /**
     * Appends to the recipe full menu order: name and price.
     *
     * @return StringBuilder instance
     */
    private StringBuilder appendFullMenuToRecipe() {
        return new StringBuilder()
                .append("Dish: ").append(this.orderDTO.getMainDish()).append("  ").append(this.validateDishPrice(this.orderDTO))
                .append('\n')
                .append("Dessert: ").append(this.orderDTO.getDessert()).append("  ").append(this.validateDessertPrice(this.orderDTO))
                .append('\n')
                .append("Drink: ").append(this.orderDTO.getDrink()).append("  ").append(this.validateDrinkPrice(this.orderDTO))
                .append('\n')
                .append(this.orderDTO.isLemon() ? "Lemon have added" + ('\n') : "")
                .append(this.orderDTO.isIce() ? "Ice have added " + ('\n') : "");
    }

    /**
     * Appends to the recipe lunch menu order: name and price.
     *
     * @return StringBuilder instance
     */
    private StringBuilder appendLunchToRecipe() {
        return new StringBuilder()
                .append("Dish: ").append(this.orderDTO.getMainDish()).append("  ").append(this.validateDishPrice(this.orderDTO))
                .append('\n')
                .append("Dessert: ").append(this.orderDTO.getDessert()).append("  ").append(this.validateDessertPrice(this.orderDTO))
                .append('\n');
    }

    /**
     * Assert that Order variables not null.
     *
     * @param order The order instance
     */
    private void assertOrderNotNull(Order order) {
        if (order == null) {
            throw new IllegalStateException("Order must not be null");
        }
        if (order.getCuisine() == null) {
            throw new IllegalStateException("Cuisine must not be null");
        }
        if (order.getMainDish() == null) {
            throw new IllegalStateException("Main dish must not be null");
        }
        if (order.getDessert() == null) {
            throw new IllegalStateException("Dessert must not be null");
        }
        if (order.getDrink() == null) {
            throw new IllegalStateException("Drink must not be null");
        }
    }

    /**
     * Returns order's DTO instance.
     *
     * @param order The order instance
     * @return OrderDTO instance
     */
    public OrderDTO getOrderDTO(Order order) {

        this.assertOrderNotNull(order);

        return OrderDTO.builder()
                .cuisine(order.getCuisine())
                .mainDish(order.getMainDish())
                .dessert(order.getDessert())
                .drink(order.getDrink())
                .lemon(order.isLemon())
                .ice(order.isIce())
                .build();
    }

}
