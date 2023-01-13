<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 7.01.2023
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String auth = (String) session.getAttribute("auth");
%>
<html>
<head>
    <title>Register Retailer</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Satıcı Kayıt Ekranı</div>
        <div class="card-body">
            <form action="retailer-register" method="POST">
                <div class="form-group">
                    <label for="exampleInputName">Isim</label>
                    <input name="name" type="text" class="form-control" id="exampleInputName" placeholder="Isim Giriniz"
                           required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Parola</label>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword1"
                           placeholder="**************" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Parola Tekrar</label>
                    <input name="passwordRepeat" type="password" class="form-control" id="exampleInputPassword2"
                           placeholder="**************" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Email Adresi</label>
                    <input name="email" type="email" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" placeholder="Email Adresinizi Giriniz" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPhoneNumber">Şifre</label>
                    <input name="phoneNumber" type="text" class="form-control" id="exampleInputPhoneNumber"
                           placeholder="Telefon Numarası Giriniz" required>
                </div>
                <div class="text-center mt-2">
                    <button type="submit" class="btn btn-primary" id="btn-submit">Kayıt Ol</button>
                </div>
                <div class="text-start">
                    <a href="/supply-chain-management-1.0-SNAPSHOT/loginRetailer.jsp">Giriş Yap</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
