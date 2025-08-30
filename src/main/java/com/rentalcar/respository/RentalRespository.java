package com.rentalcar.respository;

import com.rentalcar.entity.Customer;
import com.rentalcar.entity.Payment;
import com.rentalcar.entity.Rental;
import com.rentalcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RentalRespository {

    public void shtoRental (Rental r){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(r);
            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();
        }
    }
    public Rental getByIdRental(Long id) {
        Rental rental = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            rental = session.find(Rental.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rental;
    }


    public void deleteByIdVRental(Long id) {
        Transaction t = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            t = session.beginTransaction();

            Rental rental = session.get(Rental.class, id); // get() ensures it's managed
            if (rental != null) {
                session.remove(rental);
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
