import Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Query query = session.createQuery("from Product");

        query.setFirstResult(1);

        query.setMaxResults(5);

        List<Product> list = query.getResultList();
        /*
        for(Product product : list){
            System.out.println("Product " + product.getProductId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getPrice());
            System.out.println(product.getStockQuantity());
            System.out.println(product.getManufacturer());
            System.out.println(product.getProductionDate());
            System.out.println("");
        }*/

        query = session.createQuery("update Product set productionDate=:d where productId=:i");

        query.setParameter("d", new Date());
        query.setParameter("i", 26);

        int status = query.executeUpdate();
        System.out.println(status);

        query = session.createQuery("select sum(price) from Product");

        List<Double> list_d = query.getResultList();

        for(double d : list_d){
            System.out.println(d);
        }
        session.getTransaction().commit();
    }
}
