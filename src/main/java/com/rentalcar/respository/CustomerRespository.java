package com.rentalcar.respository;

import com.rentalcar.entity.Customer;
import com.rentalcar.entity.Payment;
import com.rentalcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRespository {

    public void shtoCustomer(Customer c){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.save(c);
            t.commit();
        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();
        }
    }
    public void deleteCustomer(Customer c1){
        Transaction t=null;
        try(Session s= HibernateUtil.getSessionFactory().openSession()){
            t=s.beginTransaction();
            s.remove(c1);
            t.commit();

        } catch(Exception e){
            if(t!=null)t.rollback(); e.printStackTrace();
        }
    }

    public Customer getById(Long id) {
        Customer customer = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            customer = session.find(Customer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }


    public void deleteCustomerById(Long id) {
        Transaction t = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            t = session.beginTransaction();

            Customer customer = session.get(Customer.class, id);
            if (customer != null) {
                session.remove(customer); // will also delete rentals
                System.out.println("Customer and associated rentals deleted.");
            } else {
                System.out.println("Customer not found.");
            }

            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
    }

}
