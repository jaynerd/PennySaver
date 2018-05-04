package core;

import bean.FinanceBean;
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
    private FinanceBean finance;

    private Statement statement;
    private Connection connection;
    private String url = "jdbc:derby://localhost:1527/sample";

    public DataManager(PersonBean person) {
        this.person = person;
        tableName = "PERSON";
        connect();
        boolean doesExist = checkExistingTable();
        if (!doesExist) {
            createPersonTable();
        }
    }

    public DataManager(FinanceBean finance) {
        this.finance = finance;
        tableName = "FINANCE";
        connect();
        boolean doesExist = checkExistingTable();
        if (!doesExist) {
            createFinanceTable();
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
                    + "AGE INT, SALARY INT, WORKHOURS INT)");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void createFinanceTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + tableName + " (DEPOSIT INT, "
                    + "DURATION DOUBLE, INTERESTRATE DOUBLE, TAXRATE DOUBLE, SPENDINGS DOUBLE, "
                    + "EARNEDINTEREST DOUBLE)");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
