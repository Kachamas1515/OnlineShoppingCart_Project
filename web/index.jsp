<%-- 
    Document   : catalog_home
    Created on : Nov 22, 2020, 10:54:08 PM
    Author     : amam
--%>

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
        <title>DVD Shopping Online</title>
    </head>
    <jsp:useBean id="catalog" class="model.Dvdcatalog" scope="request"/>
     <%        
            List<Dvdcatalog> catalogList = DvdCatalogTable.findAllCatalog();
            Iterator<Dvdcatalog> itr = catalogList.iterator();
     %>
    <body>
        <center>
            <h1 style="margin: 40px;">DVD Catalog</h1>
              <table class="table table-bordered" style="width: 60%;">
                  <tr class = "table-info">
<!--                <th style="text-align: center;">ID</th>-->
                    <th style="text-align: center;">DVD Name</th>
                    <th style="text-align: center;">Rate</th>
                    <th style="text-align: center;">Year</th>
                    <th style="text-align: center;">Price</th>
                    <th style="text-align: center;">Quantity</th>
                    <th style="text-align: center;">AddCart</th> 
                  </tr>
                  <%

                       while(itr.hasNext()) {
                           out.println("<form name=\"AddToCartController\" method=\"POST\" action=\"AddToCartController\">");
                           catalog = itr.next();
                           out.println("<tr>");
                           out.println("<td hidden style='text-align: center;'><input class=\"form-control\" type=\"number\" name=\"dvdId\" value=" + catalog.getDvdid() + "></input></td>");
                           out.println("<td style='text-align: center;'> "+ catalog.getDvdname() + "</td>");
                           out.println("<td style='text-align: center;'> "+ catalog.getRate() + "</td>");
                           out.println("<td style='text-align: center;'> "+ catalog.getYears() + "</td>");
                           out.println("<td style='text-align: center;'> "+ catalog.getPrice() + "</td>");
                           out.println("<td style='text-align: center;width: 20%;'><input class=\"form-control\" type=\"number\" name=\"quantity\" placeholder=\"Please enter Qty.\" ></input></td>");
                           out.println("<td style='text-align: center;'><button class=\"btn btn-primary\" type=\"submit\" name=\"additem\" id=\"button\" >AddToCart &nbsp;<i class=\"fa fa-shopping-cart\"></i></button></td>");
                           out.println("<tr>");
                           out.println("</form>");
                       }
                  %>
            </table>
        </center>
    </body>
</html>
