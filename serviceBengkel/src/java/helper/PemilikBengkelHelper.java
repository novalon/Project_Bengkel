/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.PemilikBengkel;

public class PemilikBengkelHelper {

    public PemilikBengkelHelper() {

    }

    public List<PemilikBengkel> getPemilikBengkel() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from PemilikBengkel";
        Query q = session.createQuery(query);
        List<PemilikBengkel> list = q.list();
        return list;
    }

    public static String toJson() {
        PemilikBengkelHelper helper = new PemilikBengkelHelper();
        List<PemilikBengkel> list = helper.getPemilikBengkel();
        String result = "[";
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                result = result + list.get(i).toJson() + ",\n";
            } else {
                result = result + list.get(i).toJson() + "\n";
            }
        }
        result = result + "]";
        return result;
    }

     public List<PemilikBengkel> getAllBengkel() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from PemilikBengkel";
        Query q = session.createQuery(query);
        List<PemilikBengkel> list = q.list();
        return list;
    }

      public List<PemilikBengkel> getlokasibengkel() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "SELECT namaBengkel, longitud, latitude FROM PemilikBengkel";
        Query q = session.createQuery(query);
        List<PemilikBengkel> list = q.list();
        return list;
    }
 
    public void addNewPB(
            String nama,
            String email,
            String password,
            String namaBengkel,
            String alamat,
            String jamBuka,
            String jenisKendaraan,
            Double longitud,
            Double latitude,
            String jamTutup
    ) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        PemilikBengkel PB = new PemilikBengkel(nama, email, password, namaBengkel, alamat, jamBuka, jenisKendaraan, longitud, latitude, jamTutup);
        session.saveOrUpdate(PB);
        tx.commit();
        session.close();
    }

    public PemilikBengkel login(String email, String password) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String q = "From PemilikBengkel p where p.email=:email AND p.password =:password";

        Query query = session.createQuery(q);
        query.setParameter("email", email);
        query.setParameter("password", password);

        return (PemilikBengkel) query.uniqueResult();
    }

}
