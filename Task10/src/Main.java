import Entity.Passport;
import Entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Person person = new Person("ahmed", "saleh", LocalDate.parse("20/04/1998", dft));
            Passport passport = new Passport("ABC123", LocalDate.parse("20/04/2025", dft));
            passport.setPersonId(person);
            session.save(passport);

            Person p = (Person) session.get(Person.class, 1);
            System.out.println(p);

            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
