Stack: <br>
    Windows OS - 10 
<br>
    IntelliJ IDEA 2023.3.4 (Community Edition)
<br>
    Postman v10.24.16
<br>
    server.port=1998
<br>
    Java v22
<br>
    spring-boot-starter 3.2.5
<br>
    lombok 1.18.32
<br>
    mockito-core 5.12.0
<br>
    unit-jupiter-api 5.10.2
<br>
--------------------------------------------------------------------------------------------------------------------

This code presents a REST controller named FoodOrderingController, which handles requests to the API for food orders.

1. All Cuisines:

URL: /api/v1/getCuisines
HTTP Method: GET
Description: Returns a list of all available cuisines.
Return Type: ResponseEntity<List<String>>


2. Cuisine Dishes:

URL: /api/v1/cuisineDishes
HTTP Method: GET
Request Parameters: cuisineType - the cuisine type
Description: Returns a list of all available dishes for the specified cuisine type.
Return Type: ResponseEntity<HashMap<String, Double>>
Example: http://localhost:1998/api/v1/cuisineDishes?cuisineType=Poland Cuisine

3. Cuisine Desserts:

URL: /api/v1/cuisineDesserts
HTTP Method: GET
Request Parameters: cuisineType - the cuisine type
Description: Returns a list of all available desserts for the specified cuisine type.
Return Type: ResponseEntity<HashMap<String, Double>>
Example: http://localhost:1998/api/v1/cuisineDesserts?cuisineType=Italy Cuisine

4. Cuisine Drinks:

URL: /api/v1/cuisineDrinks
HTTP Method: GET
Request Parameters: cuisineType - the cuisine type
Description: Returns a list of all available drinks for the specified cuisine type.
Return Type: ResponseEntity<HashMap<String, Double>>
Example: http://localhost:1998/api/v1/cuisineDrinks?cuisineType=Poland Cuisine

5. Create Order:

URL: /api/v1/createOrder
HTTP Method: POST
Request Body: JSON object of type Order
Description: Creates an order based on the provided data. Accepts an order object specifying the cuisine, main dish, dessert, drink, and additional options. Returns the recipe for the order if successful, or an error message if the order is invalid.
Return Type: ResponseEntity<StringBuilder>
The entire functionality of the controller interacts with the order service (OrderService), injected via @Autowired.
Example:

  Body -> Json:
{
    "cuisine": "Mexican Cuisine",
    "mainDish": "Burrito",
    "dessert": "Flan",
    "drink": "Tequila",
    "ice": true,
    "lemon": true
}
