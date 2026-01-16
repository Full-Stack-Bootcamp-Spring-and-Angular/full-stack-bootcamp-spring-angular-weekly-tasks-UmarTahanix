package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car implements Vehicle{
    private DatabaseOperations databaseOperations;

    private int id;

    private String brand;

    private Type type;

    @Autowired
    public Car(DatabaseOperations databaseOperations, int id, String brand){
        this.databaseOperations = databaseOperations;
        this.id = id;
        this.brand = brand;
        this.type = Type.car;
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String typeToString(){
        if(type == Type.bike)
            return "bike";
        else if(type == Type.car)
            return "car";
        else
            return "plane";
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setType(Type type){
        this.type = type;
    }
}