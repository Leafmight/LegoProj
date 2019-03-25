<%-- 
    Document   : calculateBricks
    Created on : 21-Mar-2019, 10:21:56
    Author     : jacobfolkehildebrandt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            HttpSession session1 = request.getSession();
            int[] brickList = (int[]) session1.getAttribute("brickList");
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <table>
        <h1>Length</h1>
        <h3>Bricks x4</h3>
    <tr> <% out.print(brickList[0]); %></tr>
    <h3>Bricks x2</h3>
    <tr> <% out.print(brickList[1]); %></tr>
    <h3>Bricks x1</h3>
    <tr> <% out.print(brickList[2]); %></tr>
    <h1>Width</h1>
    <h3>Bricks x4</h3>
    <tr> <% out.print(brickList[3]); %></tr>
    <h3>Bricks x2</h3>
    <tr> <% out.print(brickList[4]); %></tr>
    <h3>Bricks x1</h3>
    <tr> <% out.print(brickList[5]);%></tr>
    <form action="Controller?origin=createOrder" method="post"> <br>
    <input type="submit" value="Place your order">
    </form>
    </table>
   
</body>
</html>
