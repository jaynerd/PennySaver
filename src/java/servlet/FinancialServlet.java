package servlet;

import bean.FinanceBean;
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
            response.sendRedirect("ResultPage.jsp");
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
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
