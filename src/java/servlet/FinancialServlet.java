package servlet;

import bean.FinanceBean;
import bean.PersonBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manager.DataManager;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
@WebServlet(name = "FinancialServlet", urlPatterns = {"/FinancialServlet"})
public class FinancialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FinanceBean finance = new FinanceBean();
            finance.setDeposit(request.getParameter("deposit"));
            finance.setDuration(request.getParameter("duration"));
            finance.setInterestRate(request.getParameter("intRate"));
            finance.setTaxRate(request.getParameter("taxRate"));
            finance.setSpending(request.getParameter("spending"));

            DataManager dataManager = new DataManager(finance);
            HttpSession session = request.getSession(true);
            session.setAttribute("sessionFinance", finance);
            PersonBean person = (PersonBean) session.getAttribute("sessionUser");
            int earnedInterest = calculateInterest(finance, Integer.parseInt(person.getSalary()));
            finance.setInterest(earnedInterest);
            response.sendRedirect("ResultPage.jsp");
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    private int calculateInterest(FinanceBean finance, int salary) {
        int deposit = Integer.parseInt(finance.getDeposit());
        int interestRate = Integer.parseInt(finance.getInterestRate());
        int duration = Integer.parseInt(finance.getDuration());
        int taxRate = Integer.parseInt(finance.getTaxRate());
        int interest = 0;
        for (int i = 0; i < duration; i++) {
            interest += (deposit * (interestRate * 0.01f));
            deposit += interest;
        }
        interest -= interest * (taxRate * 0.01f);
        return interest;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
