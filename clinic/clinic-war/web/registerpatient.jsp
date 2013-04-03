<%-- 
    Document   : registerpatient
    Created on : Apr 3, 2013, 9:14:53 AM
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method ="POST" action="Controller">
            Username: <input type="text" name="username"><br/>
            Password: <input type="password" name="password"><br/>
            Re-Enter Password: <input type="password" name="password2"><br/>
            First Name: <input type="text" name="fname"><br/>
            Last Name: <input type="text" name="lname"><br/>
            Email: <input type="text" name="email"><br/>
            Note: <input type="text" name="note"><br/>
            <input type ="Submit" name="Register" value="Register">
            
            
        </form>
        
        
    </body>
</html>
