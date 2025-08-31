package com.rentalcar;

import com.rentalcar.entity.*;
import com.rentalcar.respository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Customer c1 = new Customer("Ardi", "Zefi" , "ardi.zefi@gmail.com");
        Customer c2 = new Customer("Elira", "Hoxha", "elira.hoxha@yahoo.com");
        Customer c3 = new Customer("Bledi", "Krasniqi", "bledi.krasniqi@gmail.com");
        Customer c4 = new Customer("Jonida", "Shehu", "jonida.shehu@hotmail.com");
        CustomerRespository cr = new CustomerRespository();
        cr.shtoCustomer(c1);


        //       cr.deleteCustomerById(1L);





        Vehicle v1 = new Vehicle("Toyota" , "Yaris", 2010 , 25, Status.AVAILABLE , "AB223NN");
        Vehicle v2 = new Vehicle("Honda", "Civic", 2015, 30, Status.AVAILABLE, "AB123AB");
        Vehicle v3 = new Vehicle("Ford", "Focus", 2018, 35, Status.RENTED, "AA345AB");
        Vehicle v4 = new Vehicle("BMW", "320i", 2020, 55, Status.MAINTENANCE , "AC567AB");
        VehicleRespository vr = new VehicleRespository();
        vr.shtoVehicle(v1);


        //vr.deleteByIdVehicle(1L);



        Rental r1 = new Rental(LocalDate.now().plusDays(2), LocalDate.now().plusDays(5) ,c1 ,v1);
        Rental r2 = new Rental(LocalDate.now().minusDays(3), LocalDate.now().plusDays(3), c2, v2);
        Rental r3 = new Rental(LocalDate.now().minusDays(12) , LocalDate.now().plusDays(1), c3 , v3);
        Rental r4 = new Rental(LocalDate.now().minusDays(3) , LocalDate.now().plusDays(5), c4 , v4);
        RentalRespository rp = new RentalRespository();
        rp.shtoRental(r1);


        //rp.deleteByIdVRental(1L);





        Payment p1 = new Payment(25 ,LocalDate.now() ,r1);
        Payment p2 = new Payment(30 ,LocalDate.now() ,r2);
        Payment p3 = new Payment(35 ,LocalDate.now() ,r3);
        Payment p4 = new Payment(55 ,LocalDate.now() ,r4);
        PaymentRespository pr = new PaymentRespository();
        pr.shtoPages(p1);
        // pr.deleteByIdPayment(1L);

        Inventory i1 = new Inventory(5 , r1 , v1);
        Inventory i2 = new Inventory(3, r2 ,v2);
        InventoryRepository inventoryRepository = new InventoryRepository();
        inventoryRepository.shtoInventory(i2);

    }


 }
