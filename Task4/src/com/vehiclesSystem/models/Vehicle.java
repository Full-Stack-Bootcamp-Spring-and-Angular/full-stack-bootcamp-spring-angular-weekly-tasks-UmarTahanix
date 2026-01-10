package com.vehiclesSystem.models;

public interface Vehicle {
    int getId();

    String getBrand();

    Type getType();

    String typeToString();

    void setId(int id);

    void setBrand(String brand);

    void setType(Type type);
}
