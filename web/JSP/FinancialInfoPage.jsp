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
    </center>
</body>
</html>
