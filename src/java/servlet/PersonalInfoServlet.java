package servlet;

import bean.PersonBean;
import core.DataManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Namyoon j4yn3rd@gmail.com
 */
public class PersonalInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonBean person = makePerson(request);
        DataManager dataManager = new DataManager(person);
        HttpSession session = request.getSession(true);
        session.setAttribute("sessionPerson", person);
        response.sendRedirect("FinancialInfoPage.jsp");
    }

    private PersonBean makePerson(HttpServletRequest request) {
        PersonBean person = new PersonBean();
        person.setName(request.getParameter("name"));
        person.setAge(Integer.parseInt(request.getParameter("age")));
        person.setSalary(Integer.parseInt(request.getParameter("salary")));
        person.setWorkHours(Integer.parseInt(request.getParameter("whours")));
        return person;
    }
}
