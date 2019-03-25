<%-- 
    Document   : userOrders
    Created on : 21-Mar-2019, 13:31:39
    Author     : jacobfolkehildebrandt
--%>

<%@page import="Data.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% HttpSession session1 = request.getSession();
            ArrayList<Order> o = (ArrayList<Order>) session1.getAttribute("userOrders");
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your orders</h1>
        <table>
            <%
            for (Object order : o) { %>
            <tr> <% out.print(order); %> </tr> <br>
            <% }
            %>
        </table>
    </body>
</html>
