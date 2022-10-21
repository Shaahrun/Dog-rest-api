package com.gmail.ejikemesharon.Dog.rest.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    public DogRepository dogRepository;


    public List<DogEntity> getDogs() {
        List<DogEntity> dogBreeds = (List<DogEntity>) dogRepository.findAll();
        return dogBreeds;
    }

    public List<String> getDogBreed() {
        List<String> dogBreeds = dogRepository.getBreeds();
        return dogBreeds;
    }

    public String getBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.getBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    public List<String> getDogNames() {
        List<String> dogNames = dogRepository.getDogNames();
        return dogNames;
    }





}
