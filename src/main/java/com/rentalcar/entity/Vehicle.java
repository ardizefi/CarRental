package com.rentalcar.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
    public class Vehicle {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String brand;
        private String model;
        private int year;
        private double dailyRate;
        private String targa;

        @Enumerated(EnumType.STRING)
        private Status status;

        @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
        private List<Rental> rentals =new ArrayList<>();

    public Vehicle(){}
    public Vehicle ( String brand , String model , int year , double dailyRate , Status status , String targa){
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.dailyRate=dailyRate;
        this.status=status;
        this.targa=targa;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }
}



