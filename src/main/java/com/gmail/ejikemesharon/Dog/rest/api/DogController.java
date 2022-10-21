package com.gmail.ejikemesharon.Dog.rest.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    public DogService dogService;

    @Autowired
    private void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping(path = "/dogs/breed")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> getBreeds() {
        List<String> breed = dogService.getDogBreed();
        return new ResponseEntity<List<String>>(breed, HttpStatus.OK);
    }

    @GetMapping(path = "/dogs/breed/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getBreedById(@PathVariable Long id) {
        String breedById = dogService.getBreedById(id);
        return new ResponseEntity<String>(breedById, HttpStatus.OK);
    }

    @GetMapping(path = "/dogs/name")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> getNames() {
        List<String> names = dogService.getDogNames();
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);

    }

    @GetMapping(path = "/dogs")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<DogEntity>> getDogs() {
        List<DogEntity> allDogs = dogService.getDogs();
        return new ResponseEntity<List<DogEntity>>(allDogs, HttpStatus.OK);
    }

}
