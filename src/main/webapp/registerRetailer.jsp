<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 7.01.2023
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register Retailer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="WEB-INF/common/header.jspx"%>
<form method="POST">
    <div class="form-group">
        <label for="exampleInputName">Name</label>
        <input name="name" type="text" class="form-control" id="exampleInputName">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
        <c:if test="${not empty message}">
            <h1>${message}</h1>
        </c:if>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword2">Password</label>
        <input name="passwordRepeat" type="password" class="form-control" id="exampleInputPassword2">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail">Email address</label>
        <input name="email" type="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
    </div>
    <div class="form-group">
        <label for="exampleInputPhoneNumber">Phone Number</label>
        <input name="phoneNumber" type="text" class="form-control" id="exampleInputPhoneNumber">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

<%@ include file="WEB-INF/common/footer.jspx"%>
