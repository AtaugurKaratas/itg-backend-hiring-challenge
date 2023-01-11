<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 10.01.2023
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if(session.getAttribute("supplierId") != null){
        response.sendRedirect("homePageSupplier.jsp");
    }
%>
<html>
<head>
    <title>Login Supplier</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<form method="POST" action="supplier-login">
    <div class="form-group">
        <label for="exampleInputEmail">Email address</label>
        <input name="email" type="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="submit" class="btn btn-primary" id="btn-submit">Submit</button>
    <p id="status"><%=request.getAttribute("status")%></p>
</form>
<script type="text/javascript">
    let status = document.getElementById("status").innerText;
    if (status === "null"){
        document.getElementById("status").hidden = true
    }
    document.getElementById("btn-submit").addEventListener("click", (event) => {
        status = document.getElementById("status").innerText;
        if (status !== "null"){
            document.getElementById("status").hidden = false
        }
    });
    console.log(status);
</script>
</body>
</html>
