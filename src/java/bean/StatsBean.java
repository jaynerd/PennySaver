package bean;

import core.DataManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
@Stateless
public class StatsBean {

    public void saveStats(int age, double dailySavings) {
        DataManager dataManager = new DataManager(age, dailySavings);
    }

    public int[] getStats() throws SQLException {
        int[] stats = new int[2];
        DataManager dataManager = new DataManager();
        ResultSet ages = dataManager.getAges();
        ResultSet savings = dataManager.getSavings();
        ArrayList<Integer> ageList = new ArrayList<Integer>();
        ArrayList<Double> savingList = new ArrayList<Double>();
        while (ages.next()) {
            ageList.add(ages.getInt("AGE"));
            savingList.add(savings.getDouble("DAILYSAVINGS"));
        }
        stats[0] = getAgeAverage(ageList);
        stats[1] = getSavingAverage(savingList);
        return stats;
    }

    private int getAgeAverage(ArrayList<Integer> list) {
        Integer[] intArray = new Integer[list.size()];
        intArray = list.toArray(intArray);
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }
        int average = sum / intArray.length;
        return average;
    }

    private int getSavingAverage(ArrayList<Double> list) {
        Double[] doubleArray = new Double[list.size()];
        doubleArray = list.toArray(doubleArray);
        int sum = 0;
        for (int i = 0; i < doubleArray.length; i++) {
            sum += doubleArray[i];
        }
        int average = sum / doubleArray.length;
        return average;
    }
}
