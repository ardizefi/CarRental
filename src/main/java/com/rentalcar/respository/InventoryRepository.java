package com.rentalcar.respository;

import com.rentalcar.entity.Inventory;
import com.rentalcar.entity.Payment;
import com.rentalcar.entity.Vehicle;
import com.rentalcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InventoryRepository {

    public void shtoInventory(Inventory inventory) {
        Transaction t = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            s.save(inventory);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
    }
    public void updateInventory(Inventory inventory) {
        Transaction t = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            s.update(inventory);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
    }



}
