<%-- 
    Document   : admin
    Created on : 22-Mar-2019, 10:25:32
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

            ArrayList<Order> o = (ArrayList<Order>) session1.getAttribute("allUserOrders");
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin</h1>
        <table>
        <%
            for (Object order : o) { %>
    <tr> <% out.print(order); %> </tr> <br>
    <% }
    %>
        </table>
        <form action="Controller?origin=updateShipping" method="post">
            <input type="text" name="orderID">
            <input type="submit" value="Update order">
        </form>
        
</body>
</html>