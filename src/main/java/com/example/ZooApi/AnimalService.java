package com.example.ZooApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service

public class AnimalService {

    private final AnimalRepository animalRepos;
    @Autowired
    AnimalService(AnimalRepository animalRepos){
        this.animalRepos = animalRepos;
    }

    public void create(AnimalDto a1) {

        animalRepos.save( new AnimalEntity(a1.getName(), a1.getAnimalType()));


    }
}
