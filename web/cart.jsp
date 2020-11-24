<%-- 
    Document   : catalog_home
    Created on : Nov 22, 2020, 10:54:08 PM
    Author     : amam
--%>

<%@page import="model.CartTable"%>
<%@page import="model.Cart"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.DvdCatalogTable"%>
<%@page import="model.Dvdcatalog"%>
<%@page import="model.Dvdcatalog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>DVD Shopping Cart</title>
    </head>
    <jsp:useBean id="cart" class="model.Cart" scope="request"/>
     <%        
            List<Cart> cartList = CartTable.findAllCart();
            Iterator<Cart> itr = cartList.iterator();
     %>
    <body>
        <center>
            <h1 style="margin: 40px;">DVD Shopping Cart</h1>
              <table class="table table-bordered" style="width: 60%;">
                  <tr class = "table-info">
<!--                    <th style="text-align: center;">ID</th>-->
                    <th style="text-align: center;">DVD Name</th>
                    <th style="text-align: center;">Rate</th>
                    <th style="text-align: center;">Year</th>
                    <th style="text-align: center;">Price</th>
                    <th style="text-align: center;">Quantity</th>
                    <th style="text-align: center;">Remove</th> 
                  </tr>
                  <%

                       while(itr.hasNext()) {
                           out.println("<form name=\"RemoveFromCartController\" method=\"post\" action=\"RemoveFromCartController\">");
                           cart  = itr.next();
                           out.println("<tr>");
                           out.println("<td hidden style='text-align: center;'><input class=\"form-control\" type=\"number\" name=\"cartId\" value=" + cart.getCartid() + "></input></td>");
                           out.println("<td style='text-align: center;'> "+ cart.getDvdid().getDvdname() + "</td>");
                           out.println("<td style='text-align: center;'> "+ cart.getDvdid().getRate() + "</td>");
                           out.println("<td style='text-align: center;'> "+ cart.getDvdid().getYears() + "</td>");
                           out.println("<td style='text-align: center;'> "+ cart.getDvdid().getPrice() + "</td>");
                           out.println("<td style='text-align: center;'> "+ cart.getQuantity() + "</td>");
                           out.println("<td style='text-align: center;'><button class=\"btn btn-danger\" type=\"submit\" name=\"removeitem\" id=\"button\" >Remove &nbsp;<i class=\"fa fa-trash\"></i></button></td>");
                           out.println("<tr>");
                           out.println("</form>");
                       }
                  %>
            </table>
            <br>
            <button class="btn btn-primary" type="submit" name="back" onclick="window.location.href = '/OnlineShoppingCart_60050132/index.jsp'"><i class="fa fa-arrow-left"></i> &nbsp;Back to Catalog</button>
            &nbsp;
            <button class="btn btn-primary" type="submit" name="checkoutitem" onclick="window.location.href = '/OnlineShoppingCart_60050132/CheckOutController'">Check Out &nbsp; <i class="fa fa-calculator"></i></button>
        </center>
    </body>
</html>
