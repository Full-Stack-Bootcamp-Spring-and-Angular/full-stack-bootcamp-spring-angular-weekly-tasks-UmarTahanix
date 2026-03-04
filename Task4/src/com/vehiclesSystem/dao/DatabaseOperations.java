package com.vehiclesSystem.dao;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import com.vehiclesSystem.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class DatabaseOperations {
    Connection connection;

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    public DatabaseOperations(){}

    @PostConstruct
    public void connectToDatabase(){
        try{
            connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            String sql = "CREATE TABLE vehicle(" +
                    "id INT NOT NULL," +
                    "brand VARCHAR(255) NOT NULL," +
                    "type VARCHAR(255) NOT NULL" +
                    ");";
            st.executeQuery(sql);
            System.out.println("Connection established.......");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void disconnectToDatabase(){
        try {
            connection.close();
            System.out.println("Connection terminated.......");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Vehicle vehicle){
        try {
            String sql = "INSERT INTO vehicle (id, brand, type) VALUES (?, ?, ?);";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, vehicle.getId());
            prepSt.setString(2, vehicle.getBrand());
            prepSt.setString(3, vehicle.typeToString());
            prepSt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try{
            String sql = "DELETE FROM vehicle WHERE id = ?;";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, id);
            prepSt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Vehicle searchById(int id){
        try{
            Vehicle vehicle;
            String sql = "SELECT * FROM vehicle WHERE id = ?";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, id);
            ResultSet rs = prepSt.executeQuery();
            rs.next();
            System.out.println(String.format("Vehicle id: %d, Vehicle brand: %s, Vehicle type: %s",
                    rs.getInt(1), rs.getString(2), rs.getString(3)));
            if(rs.getString(3).equals("bike")) {
                vehicle = new Bike(rs.getInt(1), rs.getString(2));
            }
            else if(rs.getString(3).equals("car")) {
                vehicle = new Car(this, rs.getInt(1), rs.getString(2));
            }
            else{
                vehicle = new Plane(rs.getInt(1), rs.getString(2));
            }
            return vehicle;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Vehicle> getAllVehicles(){
        try{
            List<Vehicle> vehicle_list = new ArrayList<>();
            Vehicle vehicle;
            String sql = "SELECT * FROM vehicle;";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet rs = prepSt.executeQuery();
            while(rs.next()){
                System.out.println(String.format("Vehicle id: %d, Vehicle brand: %s, Vehicle type: %s",
                        rs.getInt(1), rs.getString(2), rs.getString(3)));
                if(rs.getString(3).equals("bike")) {
                    vehicle = new Bike(rs.getInt(1), rs.getString(2));
                }
                else if(rs.getString(3).equals("car")) {
                    vehicle = new Car(this, rs.getInt(1), rs.getString(2));
                }
                else{
                    vehicle = new Plane(rs.getInt(1), rs.getString(2));
                }
                vehicle_list.add(vehicle);
            }
            return vehicle_list;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void update(int id, String brand, String type){
        try {
            String sql = "UPDATE vehicle brand = ?, type = ? WHERE id = ?;";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setString(1, brand);
            prepSt.setString(2, type);
            prepSt.setInt(3, id);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
