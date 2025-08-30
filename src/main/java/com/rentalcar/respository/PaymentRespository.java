package com.rentalcar.respository;

import com.rentalcar.entity.Customer;
import com.rentalcar.entity.Payment;
import com.rentalcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentRespository {

    public void shtoPages(Payment p) {
        Transaction t = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            s.save(p);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
    }

    public Payment getById(Long id) {
        Payment payment = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            payment = session.find(Payment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payment;
    }


    public void deleteByIdPayment(Long id) {
        Transaction t = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            t = session.beginTransaction();

            Payment payment = session.get(Payment.class, id); // fetch managed entity
            if (payment != null) {
                session.remove(payment);
                System.out.println("Payment deleted successfully.");
            } else {
                System.out.println("Payment with ID " + id + " not found.");
            }

            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
    }

}
