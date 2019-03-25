<%-- 
    Document   : shop
    Created on : 20-Mar-2019, 13:57:12
    Author     : jacobfolkehildebrandt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shop</h1>
        <a href="Controller?origin=userOrders" >View your previous orders</a>
        <form action="Controller?origin=calculateBricks" method="post">
            <table>
                <tr>
                    <th>
                        Length
                    </th>
                    <th>
                        Width
                    </th>
                    <th>
                        Height
                    </th>
                </tr>
                <tr>
                    <td>
                        <input type="text" class="form-control" name="Length">
                    </td>

                    <td>
                        <input type="text" class="form-control" name="Width">
                    </td>
                    <td>
                        <input type="text" class="form-control" name="Height">
                    </td>

                </tr>

            </table>
            <input type="radio" name="band" value="1" checked> ½-Stoneband<br>
            <input type="radio" name="band" value="2"> 1/4-StoneBand<br>
            <input type="radio" name="band" value="3"> Brick Band<br>
            <input type="radio" name="band" value="4"> Cross Band<br>
            <input type="radio" name="band" value="5"> English Band <br>
            <br>
            <input type="submit" value="Calculate needed bricks">
        </form>


    </body>
</html>
