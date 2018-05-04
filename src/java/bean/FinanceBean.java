package bean;

import javax.ejb.Stateful;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
@Stateful
public class FinanceBean {

    private int deposit;
    private double duration;
    private double interestRate;
    private double taxRate;
    private double spendings;
    private double earnedInterest;

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getSpendings() {
        return spendings;
    }

    public void setSpendings(double spendings) {
        this.spendings = spendings;
    }

    public double getEarnedInterest() {
        return earnedInterest;
    }

    public void setEarnedInterest(double earnedInterest) {
        this.earnedInterest = earnedInterest;
    }
}
