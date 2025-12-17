import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle circle = (Circle) context.getBean("myCircle");
        circle.setRadius(3);
        String circle_area = String.format(Locale.ENGLISH, "the area of the circle = %f", circle.getArea());
        System.out.println(circle_area);

        Square square = (Square) context.getBean("mySquare");
        square.setSide(3);
        String square_area = String.format(Locale.ENGLISH,"the area of the square = %f", square.getArea());
        System.out.println(square_area);
    }
}
