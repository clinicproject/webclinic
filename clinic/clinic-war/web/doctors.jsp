<%-- 
    Document   : doctors
    Created on : 27-Mar-2013, 11:12:46 PM
    Author     : Julia
--%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.ejb.EJB, entity.*, session.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctors</title>
    </head>
         <body>
        <h1>List of doctors</h1>
        <a href="insert.jsp">insert</a><br/>
        <a href="search.jsp">search</a>
        <table border="0" cellpadding="15">
        <%
        InitialContext ctx = new InitialContext();
            DoctorSessionBeanRemote doctorSessionBeanRemote = (DoctorSessionBeanRemote)ctx.lookup(DoctorSessionBeanRemote.class.getName());
            List<Idoctor> doctors = doctorSessionBeanRemote.getAllDoctors();
            for(int i=0; i< doctors.size(); i++){
                Idoctor doctor = doctors.get(i);
                out.println("<tr><td>"+doctor.getFName()+"</td><td>"+doctor.getLName()+"</td><td>"+doctor.showTypeofDoctor()+"</td><td>"+doctor.getSpecialty()+"</td><td><a href=\"edit.jsp?id="+doctor.getDoctorID().toString()+"\">edit</a></td><td><a href=\"delete.jsp?id="+doctor.getDoctorID().toString()+"\">del</a></td></tr>");
                        }
        %>  
       
        </table>
    </body>
</html>
