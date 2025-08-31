package com.rentalcar.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int stock;

    @OneToOne
    @JoinColumn(name = "vehichle_id")
    private Vehicle vehicle;



public Inventory(){}

    public Inventory (int stock , Vehicle vehicle1){
        this.stock=stock;

        this.vehicle=vehicle1;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }



}
