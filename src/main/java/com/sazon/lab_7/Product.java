package com.sazon.lab_7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates Getters, Setters, toString, etc.
@AllArgsConstructor // Generates a constructor with all arguments
@NoArgsConstructor  // Generates an empty constructor
public class Product {
    private Long id;
    private String name;
    private Double price;
}