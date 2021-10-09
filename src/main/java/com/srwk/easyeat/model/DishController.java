package com.srwk.easyeat.model;

import java.util.*;

import com.srwk.easyeat.dto.DishDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {
    
    
    private final DishRepository repository;

    DishController(DishRepository repository) {
       this.repository = repository; 
    }

    @GetMapping("/dishes")
    public List<Dish> all() {
        return repository.findAll();
    }

    @PostMapping("/dishes")
    public Dish newDish(@RequestBody DishDTO dish) {
        Dish persistentDish = new Dish();
        persistentDish.setName(dish.getName());
        persistentDish.setDetails(dish.getDetails());
        persistentDish.setPrice(dish.getPrice());
        return repository.save(persistentDish);
    }

    @GetMapping("/dishes/{id}")
    public Dish one(@PathVariable Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("id not found - " + id));
    }

    @PutMapping("/dishes/{id}")
    public Dish replaceDish(@RequestBody DishDTO newDish, @PathVariable Long id){

        Dish persistentDish = new Dish();
        persistentDish.setName(newDish.getName());
        persistentDish.setDetails(newDish.getDetails());
        persistentDish.setPrice(newDish.getPrice());

        return  repository.findById(id)
          .map(dish -> {
            dish.setName(persistentDish.getName());
            dish.setPrice(persistentDish.getPrice());
            return repository.save(dish);
        })
        .orElseGet (() -> {
            persistentDish.setId(id);
        return repository.save(persistentDish);
        });
    }

    @DeleteMapping("/dishes/{id}")
    public void deleteDish( @PathVariable Long id){
        repository.deleteById(id);
    }

}
