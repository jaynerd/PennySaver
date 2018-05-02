package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
public class DataManager {

    public void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/mysql";
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection con = DriverManager.getConnection(url, "root", "870810");
            } catch (SQLException ex) {
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
