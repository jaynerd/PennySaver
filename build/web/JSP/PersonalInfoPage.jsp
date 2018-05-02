<%-- 
    Author     : Namyoon j4yn3rd@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Information Page</title>
    </head>
    <body>
        <h1>Personal Details</h1>
        <form action="PersonalServlet">
            Please enter your name:
            <input type="text" name="name"/><br>
            Please enter you age:
            <input type="text" name="age"/><br>
            Please enter your annual salary:
            <input type="text" name="salary"/><br>
            Please enter your working hours per week:
            <input type="text" name="hours"/><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
