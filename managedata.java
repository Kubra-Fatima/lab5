import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Created by nashm on 29/03/2017.
 */
public class managedata {
    private static SessionFactory factory;

   managedata(){
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void addEntry(int id, String co, String re, String ci, String lat, String lon){
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            areaLocation al = new areaLocation(id, co, re, ci, lat, lon);
            session.persist(al);
            tx.commit();
        }
        catch(HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally{
            session.close();
        }

    }




}
