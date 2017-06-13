<%-- 
    Document   : index
    Created on : Jun 13, 2017, 4:14:38 PM
    Author     : ignite259
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <h1> Register</h1>
        <form action="PractiseServlet" method="POST">
            <input type="text" name="email" placeholder="email"><br><br>
            <input type="password" name="password" placeholder="pswd"><br><br>
            <input type="submit">
        </form>
        <h1> Login</h1>
        <form action="Login" method="POST">
            <input type="text" name="email" placeholder="email"><br><br>
            <input type="password" name="password" placeholder="pswd"><br><br>
            <input type="submit">
        </form>
        <h1> Delete </h1>
        <form action="DeleteData" method="POST">
            <input type="text" name="userId"/>
            <input type="submit"/>
        </form>
    </body>
</html>
