package testgroup.filmography;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting...");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }
    }
}
