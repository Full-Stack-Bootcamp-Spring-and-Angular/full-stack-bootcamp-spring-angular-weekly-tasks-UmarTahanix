import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle c = (Circle) con.getBean("myCircle");
        c.setRadius(3);
        System.out.println("the area of the circle = " + c.getArea());

        Square s = (Square) con.getBean("mySquare");
        s.setSide(3);
        System.out.println("the area of the square = " + s.getArea());
    }
}
