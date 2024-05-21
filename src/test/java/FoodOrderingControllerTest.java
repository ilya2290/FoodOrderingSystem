import com.example.api.FoodOrderingController;
import com.example.order.Order;
import com.example.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class FoodOrderingControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private FoodOrderingController foodOrderingController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test to verify the behavior of the 'allCuisines' endpoint when the service returns a valid list of cuisines.
     * <p>
     * Scenario: The orderService successfully retrieves a list of all available cuisines.
     * <p>
     * Given a list of cuisines ("Mexican Cuisine", "Italian Cuisine") returned by the orderService,
     * when the 'allCuisines' endpoint is called,
     * then the response should have an HTTP status of 200 OK,
     * and the body of the response should match the list of cuisines provided by the orderService.
     */
    @Test
    public void testAllCuisines_Valid() {
        List<String> cuisines = List.of("Mexican Cuisine", "Italian Cuisine");
        when(orderService.getAllCuisines()).thenReturn(cuisines);

        ResponseEntity<List<String>> response = foodOrderingController.allCuisines();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cuisines, response.getBody());
    }

    /**
     * Test to verify the behavior of the 'cuisineDishes' endpoint when an invalid cuisine type is provided.
     * <p>
     * Scenario: The orderService throws an IllegalArgumentException when an invalid cuisine type is requested.
     * <p>
     * Given an invalid cuisine type that causes the orderService to throw an IllegalArgumentException,
     * when the 'cuisineDishes' endpoint is called with this invalid cuisine type,
     * then the response should have an HTTP status of 400 BAD REQUEST,
     * and the response body should be null or empty as the service fails to retrieve the dishes.
     */
    @Test
    public void testCuisineDishes_InvalidCuisine() {
        when(orderService.getAllCuisineDishes(anyString())).thenThrow(IllegalArgumentException.class);

        ResponseEntity<HashMap<String, Double>> response = foodOrderingController.cuisineDishes("Invalid Cuisine");

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    /**
     * Test to verify the behavior of the 'cuisineDishes' endpoint when a valid cuisine type is provided.
     * <p>
     * Scenario: The orderService successfully retrieves a list of dishes for a given valid cuisine type.
     * <p>
     * Given a valid cuisine type ("Mexican Cuisine") and a list of dishes with their prices returned by the orderService,
     * when the 'cuisineDishes' endpoint is called with this valid cuisine type,
     * then the response should have an HTTP status of 200 OK,
     * and the body of the response should match the list of dishes and their prices provided by the orderService.
     */
    @Test
    public void testCuisineDishes_ValidDish() {
        HashMap<String, Double> dishes = new HashMap<>();
        dishes.put("Burrito", 8.99);

        String cuisineType = "Mexican Cuisine";

        //Return dishes when called with any string argument (anyString()).
        when(orderService.getAllCuisineDishes(anyString())).thenReturn(dishes);

        ResponseEntity<HashMap<String, Double>> response = foodOrderingController.cuisineDishes(cuisineType);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dishes, response.getBody());
    }

    /**
     * Test to verify the behavior of the 'cuisineDesserts' endpoint when a valid cuisine type is provided.
     * <p>
     * Scenario: The orderService successfully retrieves a list of desserts for a given valid cuisine type.
     * <p>
     * Given a valid cuisine type ("Italy Cuisine") and a list of desserts with their prices returned by the orderService,
     * when the 'cuisineDesserts' endpoint is called with this valid cuisine type,
     * then the response should have an HTTP status of 200 OK,
     * and the body of the response should match the list of desserts and their prices provided by the orderService.
     */
    @Test
    public void testCuisineDesserts_ValidCuisineType() {
        String cuisineType = "Italy Cuisine";
        HashMap<String, Double> desserts = new HashMap<>();
        desserts.put("Tiramisu", 14.99);

        when(orderService.getAllCuisineDesserts(cuisineType)).thenReturn(desserts);

        ResponseEntity<HashMap<String, Double>> response = foodOrderingController.cuisineDesserts(cuisineType);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(desserts, response.getBody());
    }

    /**
     * Test to verify the behavior of the 'cuisineDrinks' endpoint when a valid cuisine type is provided.
     * <p>
     * Scenario: The orderService successfully retrieves a list of drinks for a given valid cuisine type.
     * <p>
     * Given a valid cuisine type ("Italian Cuisine") and a list of drinks with their prices returned by the orderService,
     * when the 'cuisineDrinks' endpoint is called with this valid cuisine type,
     * then the response should have an HTTP status of 200 OK,
     * and the body of the response should match the list of drinks and their prices provided by the orderService.
     */
    @Test
    public void testCuisineDrinks_ValidCuisineType() {
        String cuisineType = "Italian Cuisine";
        HashMap<String, Double> drinks = new HashMap<>();
        drinks.put("Espresso", 2.99);
        when(orderService.getAllCuisineDrinks(cuisineType)).thenReturn(drinks);

        ResponseEntity<HashMap<String, Double>> response = foodOrderingController.cuisineDrinks(cuisineType);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(drinks, response.getBody());
    }

    /**
     * Test to verify the behavior of the 'cuisineDrinks' endpoint when an invalid cuisine type is provided.
     * <p>
     * Scenario: The orderService throws an IllegalArgumentException when an invalid cuisine type is requested.
     * <p>
     * Given an invalid cuisine type ("Invalid Cuisine") that causes the orderService to throw an IllegalArgumentException,
     * when the 'cuisineDrinks' endpoint is called with this invalid cuisine type,
     * then the response should have an HTTP status of 400 BAD REQUEST,
     * and the response body should be null, as the service fails to retrieve the drinks.
     */
    @Test
    public void testCuisineDrinks_InvalidCuisineType() {
        String invalidCuisineType = "Invalid Cuisine";
        when(orderService.getAllCuisineDrinks(invalidCuisineType)).thenThrow(new IllegalArgumentException());

        ResponseEntity<HashMap<String, Double>> response = foodOrderingController.cuisineDrinks(invalidCuisineType);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    /**
     * Test to verify the behavior of the 'createOrder' endpoint when an empty JSON is provided.
     * <p>
     * Scenario: The orderService detects the provided order as invalid due to an empty JSON.
     * <p>
     * Given an empty JSON order provided to the 'createOrder' endpoint,
     * when the 'validateOrderContent' method in orderService is called with this empty order,
     * then the orderService should return false indicating the order is invalid,
     * and the 'invalidOrderMessage' method in orderService should return a message indicating the invalid order.
     * <p>
     * Therefore, the response from the 'createOrder' endpoint should have an HTTP status of 400 BAD REQUEST,
     * and the response body should contain the message returned by the orderService.
     */
    @Test
    public void testCreateOrder_Invalid_EmptyJason() {
        Order order = Order.builder().build();

        when(orderService.validateOrderContent(order)).thenReturn(false);
        when(orderService.invalidOrderMessage()).thenReturn(new StringBuilder("Invalid order"));

        ResponseEntity<StringBuilder> response = foodOrderingController.createOrder(order);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid order", Objects.requireNonNull(response.getBody()).toString());
    }

    /**
     * Test to verify the behavior of the 'createOrder' endpoint when a valid order is provided.
     * <p>
     * Scenario: The orderService successfully validates the provided order and prepares the recipe.
     * <p>
     * Given a valid order with specified cuisine, main dish, dessert, drink, ice, and lemon preferences,
     * when the 'validateOrderContent' method in orderService is called with this order,
     * then the orderService should return true indicating the order is valid.
     * <p>
     * Additionally, when the 'prepareRecipe' method in orderService is called, it should prepare the recipe.
     * <p>
     * Therefore, the response from the 'createOrder' endpoint should have an HTTP status of 200 OK,
     * and the response body should contain the prepared recipe returned by the orderService.
     */
    @Test
    public void testCreateOrder_ValidOrder_ReturnsOkResponse() {
        Order order = Order.builder()
                .cuisine("Poland Cuisine")
                .mainDish("Zurek")
                .dessert("Andrut")
                .drink("Goldwasser")
                .ice(true)
                .lemon(true)
                .build();
        when(orderService.validateOrderContent(order)).thenReturn(true);
        when(orderService.prepareRecipe()).thenReturn(new StringBuilder("Recipe"));

        ResponseEntity<StringBuilder> response = foodOrderingController.createOrder(order);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Recipe", Objects.requireNonNull(response.getBody()).toString());
    }

    /**
     * Test to verify the behavior of the 'createOrder' endpoint when an invalid order is provided.
     * <p>
     * Scenario: The orderService detects the provided order as invalid and returns an error message.
     * <p>
     * Given an invalid order with specified cuisine, main dish, dessert, drink, ice, and lemon preferences,
     * when the 'validateOrderContent' method in orderService is called with this order,
     * then the orderService should return false indicating the order is invalid.
     * <p>
     * Additionally, when the 'invalidOrderMessage' method in orderService is called, it should return an error message.
     * <p>
     * Therefore, the response from the 'createOrder' endpoint should have an HTTP status of 400 BAD REQUEST,
     * and the response body should contain the error message returned by the orderService.
     */
    @Test
    public void testCreateOrder_InvalidOrder_ReturnsBadRequestResponse() {
        Order order = Order.builder()
                .cuisine("Poland Cuisine")
                .mainDish("Zurek")
                .dessert("Andrut")
                .drink("Goldwasser")
                .ice(true)
                .lemon(true)
                .build();
        when(orderService.validateOrderContent(order)).thenReturn(false);
        when(orderService.invalidOrderMessage()).thenReturn(new StringBuilder("Invalid Order"));

        ResponseEntity<StringBuilder> response = foodOrderingController.createOrder(order);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid Order", Objects.requireNonNull(response.getBody()).toString());
    }

    /**
     * Test to verify the behavior of the 'createOrder' endpoint when a valid order is provided.
     * <p>
     * Scenario: The orderService successfully validates the provided order and prepares the recipe.
     * <p>
     * Given a valid order with specified cuisine, main dish, dessert, drink, ice, and lemon preferences,
     * when the 'validateOrderContent' method in orderService is called with this order,
     * then the orderService should return true indicating the order is valid.
     * <p>
     * Additionally, when the 'prepareRecipe' method in orderService is called, it should prepare the recipe.
     * <p>
     * Therefore, the response from the 'createOrder' endpoint should have an HTTP status of 200 OK,
     * and the response body should match the expected recipe content.
     */
    @Test
    public void testCreateOrder_ValidOrder_ReturnsOkResponse2() {
        Order order = Order.builder()
                .cuisine("Poland Cuisine")
                .mainDish("Zurek")
                .dessert("Andrut")
                .drink("Goldwasser")
                .ice(true)
                .lemon(true)
                .build();

        StringBuilder expectedResponseBody = new StringBuilder()
                .append("Cuisine: Poland Cuisine\n")
                .append("Dish: Zurek  20.0\n")
                .append("Dessert: Andrut  5.0\n")
                .append("Drink: Goldwasser  200.0\n")
                .append("Lemon have added\n")
                .append("Ice have added\n")
                .append("Recipe price: 225.0");

        when(orderService.validateOrderContent(order)).thenReturn(true);
        when(orderService.prepareRecipe()).thenReturn(expectedResponseBody);

        ResponseEntity<StringBuilder> response = foodOrderingController.createOrder(order);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponseBody.toString(), Objects.requireNonNull(response.getBody()).toString());
    }
}
