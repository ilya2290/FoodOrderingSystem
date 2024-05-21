package com.example.order;

import lombok.*;

/**
 * The order class.
 */

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class  Order {
    private String cuisine;
    private String mainDish;
    private String dessert;
    private String drink;
    private boolean ice;
    private boolean lemon;
}


