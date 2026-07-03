package integradora_poo_2026.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnector {
    private static Properties props = new Properties();

    static {
        try (InputStream input = SQLConnector.class.getClassLoader().getResourceAsStream("credentials.properties")) {
            if (input == null) {
                System.out.println("Lo siento, no se pudo encontrar credentials.properties");
            } else {
                props.load(input);
                Class.forName(props.getProperty("db.driver"));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }
}