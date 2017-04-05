import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by nashm on 29/03/2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();

        String csvFile = "/F:/GeoLiteCity-Location.csv";
       managedata ml = new managedata();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String[] Line;
        String[] temp;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            int lineNo = 0;
            while ((line = br.readLine()) != null){
                lineNo++;

                if(lineNo >2){
                    temp = line.split(cvsSplitBy);
                    System.out.println(line);

                        int id =Integer.parseInt(temp[0]);
                        String country = temp[1].replace("\"", "");
                        String region = temp[2].replace("\"", "");
                        String city = temp[3].replace("\"", "");
                        String lon=temp[5].replace("\"", "");
                        String lat= temp[6].replace("\"", "");
                       // String postalCode = temp[4].replace("\"", "");
                       // float lon = Float.parseFloat(temp[5]);
                       // float lat = Float.parseFloat(temp[6].replace("\"", ""));

                        ml.addEntry(id, country, region, city,lon, lat);


                }

            }



            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}