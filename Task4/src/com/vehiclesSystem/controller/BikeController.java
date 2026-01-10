package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class BikeController implements VehicleController{
    @Autowired
    private DatabaseOperations databaseOperations;

    @Override
    public void saveVehicle(Vehicle vehicle){
        databaseOperations.save(vehicle);
    }

    @Override
    public Vehicle getById(int id){
        return databaseOperations.searchById(id);
    }

    @Override
    public void updateVehicle(int id, String brand, String type){
        databaseOperations.update(id, brand, type);
    }

    @Override
    public void deleteVehicle(int id){
        databaseOperations.delete(id);
    }
}
