package com.example.ZooApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Animal {

    String name;
    String animalType;

    public Animal(String name, String type) {
        this.name = name;
        this.animalType = type;
    }
}
