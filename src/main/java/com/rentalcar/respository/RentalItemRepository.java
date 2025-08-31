package com.rentalcar.respository;

import com.rentalcar.entity.Inventory;
import com.rentalcar.entity.RentalItem;
import com.rentalcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RentalItemRepository {

    public void shtoRentalItem(RentalItem rentalItem) {
        Transaction t = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            t = s.beginTransaction();
            s.save(rentalItem);
            t.commit();
        } catch (Exception e) {
            if (t != null) t.rollback();
            e.printStackTrace();
        }
    }
}
