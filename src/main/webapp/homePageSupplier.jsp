<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 10.01.2023
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if(session.getAttribute("supplierId") == null){
        response.sendRedirect("loginSupplier.jsp");
    }
%>
<html>
<head>
    <title>HomePage Supplier</title>
</head>
<body>
</body>
</html>
