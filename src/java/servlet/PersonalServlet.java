package servlet;

import bean.PersonBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
public class PersonalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PersonBean person = new PersonBean();
            person.setName(request.getParameter("name"));
            person.setAge(request.getParameter("age"));
            person.setSalary(request.getParameter("salary"));
            person.setHours(request.getParameter("hours"));

            HttpSession session = request.getSession(true);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
