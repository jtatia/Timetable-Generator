package application.DatabaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dell on 11/11/2017.
 */
public class DatabaseConnection {
    public static Connection conn = null;
    public static void openConnection()
    {
        String connectionUrl="jdbc:mysql://localhost:3306/abc";
        String userName="root";
        String userPass="madrigal";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection(connectionUrl,userName,userPass);
            System.out.println("******* Connection created successfully........");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
