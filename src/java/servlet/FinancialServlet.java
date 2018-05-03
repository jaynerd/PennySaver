package servlet;

import bean.FinanceBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            /**
             * person.setName(request.getParameter("name"));
             * person.setAge(request.getParameter("age"));
             * person.setSalary(request.getParameter("salary"));
             * person.setHours(request.getParameter("hours"));
             *
             * DataManager dataManager = new DataManager(person); HttpSession
             * session = request.getSession(true);
             * session.setAttribute("sessionUser", person);
             */
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
