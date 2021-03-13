package com.example.ZooApi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Zoo {
    ArrayList<Animal> animalsList;
    Zoo(){
        this.animalsList = new ArrayList<Animal>();
    }
    @PostMapping("/animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimal(Animal a1)
    {
        animalsList.add(a1);
    }
}
