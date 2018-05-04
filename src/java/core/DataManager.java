package core;

import bean.FinanceBean;
import bean.PersonBean;
import bean.StatsBean;
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
        insertPerson();
    }

    public DataManager(FinanceBean finance) {
        this.finance = finance;
        tableName = "FINANCE";
        connect();
        boolean doesExist = checkExistingTable();
        if (!doesExist) {
            createFinanceTable();
        }
        insertFinance();
    }

    public DataManager(int age, double dailySavings) {
        tableName = "STATISTICS";
        connect();
        boolean doesExist = checkExistingTable();
        if (!doesExist) {
            createStatisticsTable();
        }
        insertStatistics(age, dailySavings);
    }

    public DataManager() {
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
                    + "DURATION DOUBLE, INTERESTRATE DOUBLE, TAXRATE DOUBLE, SPENDINGS DOUBLE)");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void createStatisticsTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + tableName + " (AGE INT, "
                    + "DAILYSAVINGS DOUBLE)");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertPerson() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO PERSON VALUES('" + person.getName() + "', " + person.getAge()
                    + ", " + person.getSalary() + ", " + person.getWorkHours() + ")");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertFinance() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO FINANCE VALUES(" + finance.getDeposit() + ", " + finance.getDuration()
                    + ", " + finance.getInterestRate() + ", " + finance.getTaxRate() + ", " + finance.getSpendings() + ")");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertStatistics(int age, double dailySavings) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO STATISTICS VALUES(" + age + ", " + dailySavings + ")");
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getAges() {
        ResultSet ages = null;
        try {
            connect();
            statement = connection.createStatement();
            ages = statement.executeQuery("SELECT AGE FROM STATISTICS");
           // statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ages;
    }

    public ResultSet getSavings() {
        ResultSet savings = null;
        try {
            connect();
            statement = connection.createStatement();
            savings = statement.executeQuery("SELECT DAILYSAVINGS FROM STATISTICS");
            //statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return savings;
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
