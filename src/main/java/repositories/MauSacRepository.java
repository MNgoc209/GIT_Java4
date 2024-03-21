package repositories;

import entities.MauSac;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class MauSacRepository {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<MauSac> findAll() {
        String hql = "SELECT entity FROM MauSac entity";
        Query q = hSession.createQuery(hql, MauSac.class);
        return q.getResultList();
    }

    public void create(MauSac ms) {
        Transaction t = this.hSession.getTransaction();
        try {
            t.begin();
            this.hSession.persist(ms);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
    }

    public void update(MauSac ms) {
        Transaction t = this.hSession.getTransaction();
        try {
            t.begin();
            this.hSession.merge(ms);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
    }

    public void delete(MauSac ms) {
        Transaction t = this.hSession.getTransaction();
        try {
            t.begin();
            this.hSession.remove(ms);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
    }
}
