package com.example.ZooApi;

import lombok.*;

@Data
@NoArgsConstructor


public class AnimalDto {

    String name;
    String animalType;

    public String getName() {
        return name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public AnimalDto(String name, String type) {
        this.name = name;
        this.animalType = type;
    }
}
