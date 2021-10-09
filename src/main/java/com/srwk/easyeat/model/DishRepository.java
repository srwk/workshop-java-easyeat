package com.srwk.easyeat.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish , Long> {
    
}
