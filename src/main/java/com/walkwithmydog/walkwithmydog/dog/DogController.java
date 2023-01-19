package com.walkwithmydog.walkwithmydog.dog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/dogs")
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    public List<Dog> getDogs() {
        return dogService.getDogs();
    }

    public Dog createDog(@RequestBody Dog dog) {
        return dogService.createDog(dog);
    }
}