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
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
    if(session.getAttribute("supplierId") != null){
        response.sendRedirect("homePageSupplier.jsp");
    }
%>
<html>
<head>
    <title>Login Supplier</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Tedarikçi Giriş Ekranı</div>
        <div class="card-body">
            <form action="supplier-login" method="POST">
                <div class="form-group">
                    <label for="exampleInputEmail">Email Adresi</label>
                    <input name="email" type="email" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" placeholder="Email Adresinizi Giriniz" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword">Şifre</label>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword" placeholder="**************" required>
                </div>
                <div class="text-center mt-2">
                    <button type="submit" class="btn btn-primary" id="btn-submit">Giriş</button>
                    <p id="status"><%=request.getAttribute("status")%></p>
                </div>
                <div class="text-start">
                    <a href="/supply-chain-management-1.0-SNAPSHOT/registerSupplier.jsp">Kayıt Ol</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
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
