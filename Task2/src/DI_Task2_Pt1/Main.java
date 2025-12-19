package DI_Task2_Pt1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container= new ClassPathXmlApplicationContext("applicationContextPt1.xml");

        Circle circle = (Circle) container.getBean("myCircle");
        circle.draw2D();

        Square square = (Square) container.getBean("mySquare");
        square.draw2D();
    }
}
