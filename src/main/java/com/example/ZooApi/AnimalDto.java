package com.example.ZooApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class AnimalDto {

    String name;
    String animalType;

    public AnimalDto(String name, String type) {
        this.name = name;
        this.animalType = type;
    }
}
