package obochuk.vlad.DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static String URL = "jdbc:mysql://localhost:3306/users?useUnicode=true&useSSL=true";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private static Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public  DBConnector(){
            if (connection == null) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
}
