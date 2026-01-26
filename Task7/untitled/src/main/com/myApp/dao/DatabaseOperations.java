package main.com.myApp.dao;

import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
@Scope("singleton")
public class DatabaseOperations {
    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    public void storeData(Employee employee){
        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();

            String sql = String.format("CREATE DATABASE IF NOT EXISTS employees;");
            st.execute(sql);
            sql = String.format("USE employees;");
            st.execute(sql);
            sql = String.format("CREATE TABLE IF NOT EXISTS employee(" +
                    "username VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL);");
            st.execute(sql);
            st.close();

            sql = "INSERT INTO employee (username, email, password) VALUES (?, ?, ?);";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setString(1, employee.getUsername());
            prepSt.setString(2, employee.getEmail());
            prepSt.setString(3, employee.getPassword());
            prepSt.executeUpdate();
            prepSt.close();

            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
