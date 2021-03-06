/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Pojos.Location;
import Pojos.PemilikBengkel;
import util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void addNewPK(
            String nama,
            String email,
            String password
    ) {
         Session session = NewHibernateUtil.getSessionFactory().openSession();
          Transaction tx = session.beginTransaction();
           PemilikBengkel PB=new  PemilikBengkel (nama,email,password);
           session.saveOrUpdate(PB);
           tx.commit();
           session.close();
  }
    
     public PemilikBengkelHelper login(String email,String password){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String q = "From User a where a.email=:email AND a.password =:password";
        
        Query query = session.createQuery(q);
        query.setParameter("email", email);
        query.setParameter("password", password);
        
        return (PemilikBengkelHelper) query.uniqueResult();
    }
        
    }
    

