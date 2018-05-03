<%-- 
    Author     : Namyoon j4yn3rd@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    form{margin-top: 30px;}
    input{margin-top: 30px;}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Info Page</title>
    </head>
    <body>
    <center>
        <h1>Personal Details</h1>
        <form class="addMargin" action="PersonalInfoServlet">
            Please enter your name:
            <input type="text" value="Jaynerd" name="name"/><br>
            Please enter your age:
            <input type="text" value="31" name="age"/><br>
            Please enter your annual salary: $
            <input type="text" value="50000" name="salary"/><br>
            Please enter your regular weekly working hours:
            <input type="text" value="42" name="whours"/><br>
            <input type="submit" value="Next"/>
        </form>
    </body>
</center>
</html>
