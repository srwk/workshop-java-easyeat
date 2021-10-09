package com.srwk.easyeat.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dish {
    private @Id @GeneratedValue Long id;
    private String name;
    private Integer price;
    private String details;

    Dish() {}

    Dish(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Dish))
            return false;

        Dish dish = (Dish) o;

        return Objects.equals(this.id, dish.id) && Objects.equals(this.name, dish.name)
            && Objects.equals(this.price, dish.price);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.price);
    }
    
    @Override
    public String toString() {
        return "Dish ( id = " + this.id + ", name = " + this.name + ", price = " + this.price + " )";
    }
}
