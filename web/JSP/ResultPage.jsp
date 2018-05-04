<%-- 
    Author     : Namyoon j4yn3rd@gmail.com
--%>

<%@page import="bean.StatsBean"%>
<%@page import="bean.FinanceBean"%>
<%@page import="bean.PersonBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .addMargin{margin-top: 30x;}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body class="addMargin">
    <center>
        <%! int numDays = 365;%>
        <%! double workDays = 250;%>
        <%! double workHours = 8;%>
        <%! double dailyIncome = 0;%>
        <%! double dailyInterest = 0;%>
        <%! double dailySavings = 0;%>
        <h1>Results</h1>
        <% PersonBean person = ((PersonBean) (session.getAttribute("sessionPerson")));%>
        <% FinanceBean finance = ((FinanceBean) (session.getAttribute("sessionFinance")));%>
        <p>Based on your income, you earn <%=String.format("%.2f", (dailyIncome = (person.getSalary() - (person.getSalary() * finance.getTaxRate())) / numDays))%> NZD everyday after tax.</p>
        <p>Your hourly rate before tax is <%=String.format("%.2f", (person.getSalary() / workDays / workHours))%> NZD</p>
        <p> After your term deposit gets matured, you will get <%=String.format("%.2f", finance.getEarnedInterest())%> NZD as an interest after tax.</p>
        <p> Therefore, from the term deposit, you will earn <%=String.format("%.2f", (dailyInterest = finance.getEarnedInterest() / (numDays * finance.getDuration())))%> NZD daily.</p>
        <p> Based on your spending pattern, you will be able to save $<%=String.format("%.2f", (dailySavings = (dailyIncome + dailyInterest - finance.getSpendings())))%> daily, salaries included.</p>
        <%StatsBean statsBean = new StatsBean();%>
        <%statsBean.saveStats(person.getAge(), dailySavings);%>
        <form action = "StatisticsServlet" > 
            <input type = "submit" value = "Statistics"> 
        </form> 
    </center> 
</body> 
</html>
