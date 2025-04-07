package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static String getPropertyString(String filename) {
        Properties prop = new Properties();
        try {
            // Load the db.properties file from the provided filename path
            prop.load(new FileInputStream(filename));

            // Read the properties from the file
            String host = prop.getProperty("host");
            String port = prop.getProperty("port");
            String dbname = prop.getProperty("dbname");
            String user = prop.getProperty("username");
            String pass = prop.getProperty("password");

            // Return the JDBC connection string
            return "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?user=" + user + "&password=" + pass;
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if there is an error reading the properties file
        }
    }
}
