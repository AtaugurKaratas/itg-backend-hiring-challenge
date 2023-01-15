<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Supply Chain Management</title>
    <%@include file="includes/head.jsp" %>
</head>
<style>
    body{
        background-image: url("images/supply-chain-management.png");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<body>
<%@include file="includes/navbar.jsp" %>
<h1 class="text-center">Supply Chain Management</h1>
<%@include file="includes/footer.jsp" %>
</body>
</html>