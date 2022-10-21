package com.gmail.ejikemesharon.Dog.rest.api;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<DogEntity, Long> {

    @Query("select d.id, d.breed from DogEntity d where d.id=:id")
    String getBreedById(Long id);

    @Query("select d.id, d.breed from DogEntity d")
    List<String> getBreeds();

    @Query("select d.id, d.name from DogEntity d")
    List<String> getDogNames();
    
}
