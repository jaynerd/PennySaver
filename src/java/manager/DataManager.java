package manager;

import bean.FinanceBean;
import bean.PersonBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
public class DataManager {

    private String tableName = null;
    private PersonBean person;
    private FinanceBean finance;

    public DataManager(PersonBean person) {
        this.person = person;
        connect();
    }

    public DataManager(FinanceBean financeBean) {
        this.finance = finance;
        connect();
    }

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
