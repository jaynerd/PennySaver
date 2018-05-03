<%-- 
    Author     : Namyoon j4yn3rd@gmail.com
--%>

<%@page import="bean.FinanceBean"%>
<%@page import="bean.PersonBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .addMargin{margin-top: 30px;}
</style>
<html>
    <center>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Result Page</title>
        </head>
        <body class="addMagin">
            <%! int days = 365; %>
            <%! int workDays = 250; %>
            <%! int hours = 12;%>
            <h1>Results</h1>

            <% PersonBean person = ((PersonBean) (session.getAttribute("sessionUser")));%>
            <% FinanceBean finance = ((FinanceBean) (session.getAttribute("sessionFinance")));%>
            <p> You earn (after tax) $<%= ((Integer.parseInt(person.getSalary())) * (100 - Integer.parseInt(finance.getTaxRate())) / days * 0.01)%> everyday.</p>
            <p> Your hourly rate (before tax) is $<%=String.format("%.2f", (Integer.parseInt(person.getSalary()) / workDays / (double) hours))%></p>
            <p> After your term deposit gets matured, you will get $<%=finance.getInterest()%> as an interest after tax.</p>
            <p> Therefore, from the term deposit, you will earn $<%=finance.getInterest() / (days * Integer.parseInt(finance.getDuration()))%> daily.</p>
            <p> Based on your spending pattern, you will be able to save $<%=((Integer.parseInt(person.getSalary())) * (100 - Integer.parseInt(finance.getTaxRate())) / days * 0.01) + (finance.getInterest() / (days * Integer.parseInt(finance.getDuration()))) - Integer.parseInt(finance.getSpending())%> daily, salaries included.</p>
            <form action="StatisticsServlet">
                <input type="submit" value="Solutions">
                <input type="submit" value="Statistics">
            </form>
        </body>
    </center>
</html>
