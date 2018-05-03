package manager;

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

    private String tableName = null;
    private PersonBean person;
    private FinanceBean finance;

    private Connection connection;
    private Statement statement = null;

    public DataManager(PersonBean person) {
        this.person = person;
        tableName = "Personal";
        connect();
        if (!checkExistingTable(tableName)) {
            this.createPersonalTable();
            //   wordList = this.getInitialContents();
            //  this.insertToDatabase(wordList);
        }
    }

    public DataManager(FinanceBean financeBean) {
        this.finance = finance;
        tableName = "Financial";
        connect();
        if (!checkExistingTable(tableName)) {
            this.createFinancialTable();
            //  wordList = this.getInitialContents();
            //  this.insertToDatabase(wordList);
        }
    }

    public void connect() {

        String url = "jdbc:derby://localhost:1527/sample";

        try {
            connection = DriverManager.getConnection(url,"jjj","1");
        } catch (SQLException ex) {
        }

    }

    private boolean checkExistingTable(String tableName) {
        boolean flag = false;
        System.out.println("Database: Checking existing tables.");
        try {
            String[] types = {"TABLE"};
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet result = meta.getTables(null, null, null, null);
            while (result.next()) {
                String exTableName = result.getString("TABLE_NAME");
                if (exTableName.compareToIgnoreCase(tableName) == 0) {
                    System.out.println("Database: Table '" + tableName + "' already exists.");
                    flag = true;
                }
            }
            if (result != null) {
                result.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }

    private void createPersonalTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + tableName + " (NAME VARCHAR(20), "
                    + "AGE INT, SALARY INT, HOURS INT)");
            System.out.println("Database: The table '" + tableName + "' was successfully created.");
            statement.close();
        } catch (SQLException ex) {

        }
    }

    private void createFinancialTable() {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + tableName + " (INDEX INT, "
                    + "FURIGANA VARCHAR(20), KANJI VARCHAR(20), ROMAJI VARCHAR(20), "
                    + "ENGLISH VARCHAR(20), WRONGCOUNT INT)");
            System.out.println("Database: The table '" + tableName + "' was successfully created.");
            statement.close();
        } catch (SQLException ex) {

        }
    }
}
