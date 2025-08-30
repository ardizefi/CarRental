package com.rentalcar.respository;

import com.rentalcar.entity.Customer;
import com.rentalcar.entity.Payment;
import com.rentalcar.entity.Rental;
import com.rentalcar.entity.Vehicle;
import com.rentalcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VehicleRespository {

    public void shtoVehicle (Vehicle v){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(v);
            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();
        }
    }
    public Vehicle getByIdVehicle(Long id) {
        Vehicle vehicle = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            vehicle = session.find(Vehicle.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }


    public void deleteByIdVehicle(Long id) {
        Transaction t = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            t = session.beginTransaction();

            Vehicle vehicle = session.get(Vehicle.class, id); // get() ensures it's managed
            if (vehicle != null) {
                session.remove(vehicle);
                session.flush(); // force deletion
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer with ID " + id + " not found.");
            }

            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
    }
}
