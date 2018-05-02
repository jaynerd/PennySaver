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
    private PersonBean personBean;
    private FinanceBean financeBean;

    public DataManager(PersonBean personBean) {
        this.personBean = personBean;
        connect();
    }

    public DataManager(FinanceBean financeBean) {
        this.financeBean = financeBean;
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
