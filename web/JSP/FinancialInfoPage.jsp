<%-- 
    Author     : Namyoon j4yn3rd@gmail.com
--%>

<%@page import="bean.PersonBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    p{margin-top: 20px;}
    input{margin-top: 20px;}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Financial Info Page</title>
    </head>
    <body>
    <center>
        <h1>Financial Details</h1>
        <p>
            <% PersonBean person = ((PersonBean) (session.getAttribute("sessionPerson")));%>
            Hello <%=person.getName()%>, please enter your financial details.
        <form action="FinancialInfoServlet">
            How much deposit do you have? or willing to?
            <input type="text" value="10000" name="deposit"/> NZD<br>
            After how many years, will it get matured?
            <input type="text" value="5" name="duration"/> years<br>
            What's the annual interest rate?
            <input type="text" value="4.50" name="intRate"/> %<br>
            What's your tax rate?
            <input type="text" value="17.50" name="taxRate"/> %<br>
            How much do you spend daily? an estimated average is fine.
            <input type="text" value="15" name="spendings"/> NZD<br>
            <input type="submit" value="Show Results">
        </form>
    </p>
</center>
</body>
</html>
