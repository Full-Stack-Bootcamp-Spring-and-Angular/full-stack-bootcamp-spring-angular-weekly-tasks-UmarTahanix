package main.com.myApp.dao;

import lombok.Getter;
import main.com.myApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
@Scope("singleton")
@Getter
public class DatabaseOperations {
    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    public DatabaseOperations() {}

    public void storeData(User user){
        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established.....");

            Statement st = con.createStatement();
            String sql = String.format("USE users;");
            st.execute(sql);
            sql = String.format("CREATE TABLE IF NOT EXISTS user (" +
                    "firstName VARCHAR(255) NOT NULL," +
                    "lastName VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "dateOfBirth DATE NOT NULL," +
                    "city VARCHAR(255)" +
                    ");");
            st.execute(sql);
            st.close();

            sql = "INSERT INTO user (firstName, lastName, email, dateOfBirth, city) VALUES (?, " +
                    "?, ?, STR_TO_DATE(?, '%d-%m-%Y'), ?);";
            PreparedStatement prepSt = con.prepareStatement(sql);
            prepSt.setString(1, user.getFirstName());
            prepSt.setString(2, user.getLastName());
            prepSt.setString(3, user.getEmail());
            prepSt.setString(4, user.getDateOfBirth());
            prepSt.setString(5, user.getCity());
            prepSt.executeUpdate();
            prepSt.close();
            System.out.println("User entered....");

            con.close();
            System.out.println("Connection terminated.....");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
