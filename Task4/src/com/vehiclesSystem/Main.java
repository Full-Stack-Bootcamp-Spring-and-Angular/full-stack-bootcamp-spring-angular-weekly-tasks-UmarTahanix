package com.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.BikeController;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.controller.PlaneController;
import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DatabaseOperations databaseOperations = context.getBean("databaseOperations", DatabaseOperations.class);

        CarController carController = context.getBean("carController", CarController.class);

        BikeController bikeController = context.getBean("bikeController", BikeController.class);

        PlaneController planeController = context.getBean("planeController", PlaneController.class);

        databaseOperations.connectToDatabase();

        Car vehicle_1 = (Car) context.getBean("car", Car.class);
        vehicle_1.setId(1);
        vehicle_1.setBrand("toyota");
        vehicle_1.setType(Type.car);

        carController.saveVehicle(vehicle_1);

        Car vehicle_2 = (Car) context.getBean("car", Car.class);
        vehicle_2.setId(2);
        vehicle_2.setBrand("kia");
        vehicle_2.setType(Type.car);

        carController.saveVehicle(vehicle_2);

        Bike vehicle_3 = (Bike) context.getBean("bike", Bike.class);
        vehicle_3.setId(3);
        vehicle_3.setBrand("hyundai");
        vehicle_3.setType(Type.bike);

        bikeController.saveVehicle(vehicle_3);

        Plane vehicle_4 = (Plane) context.getBean("plane", Plane.class);
        vehicle_4.setId(4);
        vehicle_4.setBrand("airbus");
        vehicle_4.setType(Type.car);

        planeController.saveVehicle(vehicle_4);
    }
}
