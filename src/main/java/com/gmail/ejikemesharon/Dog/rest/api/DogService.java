package com.gmail.ejikemesharon.Dog.rest.api;

import java.util.List;

public interface DogService {
    List<DogEntity> getDogs();
    List<String> getDogBreed();
    String getBreedById(Long id);
    List<String> getDogNames();
}
