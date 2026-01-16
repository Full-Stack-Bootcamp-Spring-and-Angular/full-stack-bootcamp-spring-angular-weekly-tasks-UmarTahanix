package com.vehiclesSystem.controller;

import com.vehiclesSystem.models.Vehicle;

import java.util.List;

public interface VehicleController {
    void saveVehicle(Vehicle vehicle);

    Vehicle getById(int id);

    void updateVehicle(int id, String brand, String type);

    void deleteVehicle(int id);
}
