<%-- 
    Author     : Namyoon j4yn3rd@gmail.com
--%>

<%@page import="bean.PersonBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .addMargin{
        margin-top:20px;
    }
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Financial Information Page</title>
    </head>
    <body>
    <center>
        <h1>Financial Details</h1>
        <p class="addMargin">
            <% PersonBean person = ((PersonBean) (session.getAttribute("sessionUser")));%>
            Hello <%=person.getName()%>, please enter your financial details.
        </p>
        <form class ="addMargin" action="FinancialServlet">
            Please enter the value of your term deposit in $:
            <input class ="addMargin" type="text" name="deposit"/><br>
            How long is the term deposit for? (duration in years):
            <input class ="addMargin" type="text" name="duration"/> years<br>
            Please enter the annual interest rate:
            <input class ="addMargin" type="text" name="intRate"/> %<br>
            How much is you tax rate?:
            <input class ="addMargin" type="text" name="taxRate"/> %<br>
            How much do you spend daily? (an estimated average in $):
            <input class ="addMargin" type="text" name="spending"/> <br>
            <input class ="addMargin" type="submit" value="Show Results">
        </form>
    </center>
</body>
</html>
