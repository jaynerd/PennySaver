<%-- 
    Author     : Namyoon j4yn3rd@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .addMargin{
        margin-top:30px;
    }
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Information Page</title>
    </head>
    <body>
    <center>
        <h1>Personal Details</h1>
        <form class ="addMargin" action="PersonalServlet">
            Please enter your name:
            <input class ="addMargin" type="text" name="name"/><br>
            Please enter you age:
            <input class ="addMargin" type="text" name="age"/><br>
            Please enter your annual salary in $:
            <input class ="addMargin" type="text" name="salary"/><br>
            Please enter your working hours per week:
            <input class ="addMargin" type="text" name="hours"/><br>
            <input class ="addMargin" type="submit" value="Submit">
        </form>
    </center>
</body>
</html>
