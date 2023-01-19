package com.walkwithmydog.walkwithmydog.dog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    private final DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getDogs() {
        return dogRepository.findAll();
    }

    public Dog createDog(Dog dog) {

        Dog newDog = new Dog(dog.getName(), dog.getGender());

        return dogRepository.save(newDog);
    }

}