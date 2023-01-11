<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 10.01.2023
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if(session.getAttribute("retailerId") == null){
        response.sendRedirect("loginRetailer.jsp");
    }
%>
<html>
<head>
    <title>HomePage Retailer</title>
</head>
<body>
</body>
</html>
