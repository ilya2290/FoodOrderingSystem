package com.example.dto;

import lombok.*;

/**
 * The order DTO class.
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {
    private String cuisine;
    private String mainDish;
    private String dessert;
    private String drink;
    private boolean ice;
    private boolean lemon;
}
