package servlet;

import bean.StatsBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
@WebServlet(name = "StatisticsServlet", urlPatterns = {"/StatisticsServlet"})
public class StatisticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StatsBean statsBean = new StatsBean();
        int[] stats =new int [2];
        try {
            stats = statsBean.getStats();
       } catch (SQLException ex) {
         Logger.getLogger(StatisticsServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        HttpSession session = request.getSession(true);
        session.setAttribute("age", stats[0]);
        session.setAttribute("savings", stats[1]);
        response.sendRedirect("StatisticsPage.jsp");
    }
}
