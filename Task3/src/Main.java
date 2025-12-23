import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Task 1:\nCircles:");
        Circle circle_1 = (Circle) container.getBean("myCircle");
        System.out.println(circle_1);
        Circle circle_2 = (Circle) container.getBean("myCircle");
        System.out.println(circle_2);
        circle_1.drawCircle2D();
        circle_2.drawCircle3D();

        Draw2D draw_2d = (Draw2D) container.getBean("myDraw2D");
        Draw3D draw_3d = (Draw3D) container.getBean("myDraw3D");

        System.out.println("Squares:");

        Square square_1 = (Square) container.getBean("mySquare");
        square_1.setDraw2D(draw_2d);
        square_1.setDraw3D(draw_3d);
        System.out.println(square_1);
        Square square_2 = (Square) container.getBean("mySquare");
        square_2.setDraw2D(draw_2d);
        square_2.setDraw3D(draw_3d);
        System.out.println(square_2);
        square_1.drawSquare2D();
        square_1.drawSquare3D();
        square_2.drawSquare2D();
        square_2.drawSquare3D();

        System.out.println("Task 2:");
        DatabaseOperations db_ops = (DatabaseOperations) container.getBean("myDatabaseOperations");
        ((ClassPathXmlApplicationContext) container).close();
    }
}
