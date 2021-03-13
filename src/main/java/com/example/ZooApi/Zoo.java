package com.example.ZooApi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Zoo {
    ArrayList<AnimalDto> animalsList;
    Zoo(){
        animalsList = new ArrayList<AnimalDto>();
    }
    @PostMapping("/animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimal(@RequestBody AnimalDto a1)
    {
        animalsList.add(a1);
    }

    @GetMapping("/listAnimals")
    public ArrayList<AnimalDto> getAnimals()
    {
        System.out.println(animalsList.toString());
        return this.animalsList;
    }
}
