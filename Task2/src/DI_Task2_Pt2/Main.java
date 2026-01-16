package DI_Task2_Pt2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContextPt2.xml");

        DatabaseOperations databaseOperations = (DatabaseOperations) container.getBean("myDatabaseOperations");
        databaseOperations.databaseOperations();
    }
}
