package com.rentalcar.entity;

import jakarta.persistence.*;

@Entity
public class RentalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int days;

    @OneToOne
    @JoinColumn(name = "vehichle_id")
    private Vehicle vehicle;

    @ManyToMany
    @JoinColumn(name = "rental_id")
    private Rental rental;

    private RentalItem (int days , Vehicle vehicle1 , Rental rental1){
        this.rental=rental1;
        this.days=days;
        this.vehicle=vehicle1;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
