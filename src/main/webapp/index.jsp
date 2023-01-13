<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String auth = (String) session.getAttribute("auth");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Supply Chain Management</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%@include file="includes/footer.jsp" %>
</body>
</html>