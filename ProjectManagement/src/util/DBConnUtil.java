package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnUtil {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Use the correct path for the db.properties file
                String connStr = PropertyUtil.getPropertyString("src/resources/db.properties");
                if (connStr != null) {
                    connection = DriverManager.getConnection(connStr);
                } else {
                    System.out.println("Failed to load database properties.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
