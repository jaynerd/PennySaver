package servlet;

import bean.FinanceBean;
import bean.PersonBean;
import core.DataManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
@WebServlet(name = "FinancialInfoServlet", urlPatterns = {"/FinancialInfoServlet"})
public class FinancialInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FinanceBean finance = makeFinance(request);
        DataManager dataManager = new DataManager(finance);
        HttpSession session = request.getSession(true);
        session.setAttribute("sessionFinance", finance);
        PersonBean person = (PersonBean) session.getAttribute("sessionPerson");
        double earnedInterest = calculateEarnedInterest(person, finance);
        finance.setEarnedInterest(earnedInterest);
        response.sendRedirect("ResultPage.jsp");
    }

    private FinanceBean makeFinance(HttpServletRequest request) {
        FinanceBean finance = new FinanceBean();
        finance.setDeposit(Integer.parseInt(request.getParameter("deposit")));
        finance.setDuration(Double.parseDouble(request.getParameter("duration")));
        finance.setInterestRate(Double.parseDouble(request.getParameter("intRate")) / 100);
        finance.setTaxRate(Double.parseDouble(request.getParameter("taxRate")) / 100);
        finance.setSpendings(Double.parseDouble(request.getParameter("spendings")));
        return finance;
    }

    private double calculateEarnedInterest(PersonBean person, FinanceBean finance) {
        int deposit = finance.getDeposit();
        double interestRate = finance.getInterestRate();
        double duration = finance.getDuration();
        double taxRate = finance.getTaxRate();
        double earnedInterest = 0;
        for (int i = 0; i < (int) duration; i++) {
            earnedInterest += deposit * interestRate;
            deposit += earnedInterest;
        }
        earnedInterest -= earnedInterest * taxRate;
        return earnedInterest;
    }
}
