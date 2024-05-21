package com.example.api;

import com.example.order.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 *Rest Controller class.
 */
@RestController
public class FoodOrderingController {

    @Autowired
    private OrderService orderService;

    public FoodOrderingController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Gets the all available cuisines list.
     *
     * @return the all available cuisines list.
     */
    @GetMapping("/api/v1/getCuisines")
    public ResponseEntity<List<String>> allCuisines() {
        List<String> cuisines = this.orderService.getAllCuisines();
        if (cuisines.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cuisines);
        }
    }

    /**
     * Gets the all cuisine available dishes list.
     *
     * @param cuisineType The cuisine type
     *
     * @return The all cuisine available dishes list.
     */
    @GetMapping("/api/v1/cuisineDishes")
    public ResponseEntity<HashMap<String, Double>> cuisineDishes(@RequestParam String cuisineType) {
        HashMap<String, Double> allDishesList;

        try {
            allDishesList = this.orderService.getAllCuisineDishes(cuisineType);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(allDishesList);
    }

    /**
     * Gets the all cuisine available desserts list.
     *
     * @param cuisineType The cuisine type
     *
     * @return The all cuisine available desserts list.
     */
    @GetMapping("/api/v1/cuisineDesserts")
    public ResponseEntity<HashMap<String, Double>> cuisineDesserts(@RequestParam String cuisineType) {
        HashMap<String, Double> cuisineAllDesserts;

        try {
            cuisineAllDesserts = this.orderService.getAllCuisineDesserts(cuisineType);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(cuisineAllDesserts);
    }

    /**
     * Gets the all cuisine available drinks list.
     *
     * @param cuisineType The cuisine type
     *
     * @return The all cuisine available drink list.
     */
    @GetMapping("/api/v1/cuisineDrinks")
    public ResponseEntity<HashMap<String, Double>> cuisineDrinks(@RequestParam String cuisineType) {
        HashMap<String, Double> cuisineAllDrinks;

        try {
            cuisineAllDrinks = this.orderService.getAllCuisineDrinks(cuisineType);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(cuisineAllDrinks);
    }

    /**
     * Creates the order.
     * <p>
     * The order successful JASON example:
     * <br>
     * {
     *     "cuisine": "Mexican Cuisine",
     *     "mainDish": "Burrito",
     *     "dessert": "Flan",
     *     "drink": "Tequila",
     *     "ice": true,
     *     "lemon": true
     * }
     * <br>
     *
     * @param order The order instance.
     *
     * @return The order recipe.
     */
    @PostMapping("/api/v1/createOrder")
    public ResponseEntity<StringBuilder> createOrder(@RequestBody Order order) {
        {
            try {
                boolean isOrderValid = this.orderService.validateOrderContent(order);

                this.orderService.calculateTotalAmount(); //TODO

                if (isOrderValid)
                    return ResponseEntity.ok(this.orderService.prepareRecipe());
                else
                    return ResponseEntity.badRequest().body(this.orderService.invalidOrderMessage());
            }
            catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(this.orderService.invalidCuisineMessage());
            }
            catch (IllegalStateException exception) {
                StringBuilder isNullableFields = new StringBuilder(exception.getMessage());
                return ResponseEntity.badRequest().body(isNullableFields);
            }
        }
    }

}



