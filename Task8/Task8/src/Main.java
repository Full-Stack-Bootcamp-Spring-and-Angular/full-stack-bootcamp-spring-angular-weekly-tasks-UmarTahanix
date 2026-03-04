import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        //Add user
        User user = new User(1, "omar", "root", "omar123@gmail.com");
        session.save(user);

        //Read user
        User user1 = session.get(User.class, 1);


        //System.out.println(user1);

        //Update user
        user1.setEmail("omar@gmail.com");
        session.save(user1);

        //Delete user
        session.delete(user1);

        session.getTransaction().commit();
    }
}
