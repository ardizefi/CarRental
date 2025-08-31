package com.rentalcar.service;

import com.rentalcar.entity.*;
import com.rentalcar.respository.*;
import com.rentalcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class RentalService {

    private final CustomerRespository customerRespository = new CustomerRespository();
    private final VehicleRespository vehicleRespository = new VehicleRespository();
    private final RentalRespository rentalRespository = new RentalRespository();
    private final InventoryRepository inventoryRepository = new InventoryRepository();
    private final RentalItemRepository rentalItemRepository = new RentalItemRepository();

    //Dy metoda      voidmerr qera    void jep Qera

    public void rentVehicle(Long customerId, Long vehicleId, int days) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Customer customer = session.get(Customer.class, customerId);

            Vehicle vehicle = session.get(Vehicle.class, vehicleId);

            Inventory inventory = session.createQuery(
                    "FROM Inventory i WHERE i.vehicle.id = :vid", Inventory.class).setParameter("vid", vehicleId)
                    .getSingleResult();


            if (vehicle.getStatus() == Status.AVAILABLE && inventory.getStock() > 0) {
                Rental rental = new Rental();
                rental.setCustomer(customer);
                rental.setStartDate(LocalDate.now());
                rental.setEndDate(LocalDate.now().plusDays(days));
                rentalRespository.shtoRental(rental); // përdorim repo për rental
                RentalItem item = new RentalItem(days, vehicle, rental);
                rentalItemRepository.shtoRentalItem(item); // përdorim repo për rental item
                vehicle.setStatus(Status.RENTED);
                inventory.setStock(inventory.getStock() - 1);
                vehicleRespository.shtoVehicle(vehicle);
                inventoryRepository.updateInventory(inventory);
                System.out.println("Makinë u dha me qira!");
            } else {
                System.out.println("Makinë jo në dispozicion!");
            }
            tx.commit();
        }
    }

//    public void returnVehicle(Long customerId, Long vehicleID, int day) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Transaction tx = session.beginTransaction();
//
//            Customer customer = session.get(Customer.class, customerId);
//            Vehicle vehicle = session.get(Vehicle.class, vehicleID );
//
//        }


    }

