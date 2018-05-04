<%-- 
    Author     : Namyoon j4yn3rd@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistics Page</title>
    </head>
    <body>
        <h1>Statistics</h1>
        <p>The average age of people who use this web service is <%=(Integer) (session.getAttribute("age"))%></p>
        <p>The average savings of people who used this web service is <%=(Integer) (session.getAttribute("savings"))%></p>

    </body>
</html>
