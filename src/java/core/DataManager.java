package core;

import bean.PersonBean;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
public class DataManager {

    private String tableName;
    private PersonBean person;

    private Statement statement;
    private Connection connection;
    private String url = "jdbc:derby://localhost:1527/sample";

    public DataManager(PersonBean person) {
        this.person = person;
        tableName = "Person";
        connect();
        boolean doesExist = checkExistingTable();
        if (!doesExist) {
            createPersonTable();
        }
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(url, "app", "app");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void createPersonTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + tableName + " (NAME VARCHAR(20), "
                    + "AGE INT, SALARY INT, HOURS INT)");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void createFinancialTable() {
    }

    private boolean checkExistingTable() {
        boolean flag = false;
        try {
            String[] types = {"TABLE"};
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet result = meta.getTables(null, null, null, null);
            while (result.next()) {
                String exTableName = result.getString("TABLE_NAME");
                if (exTableName.compareToIgnoreCase(tableName) == 0) {
                    flag = true;
                }
            }
            if (result != null) {
                result.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
