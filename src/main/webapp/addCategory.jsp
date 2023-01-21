<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 21.01.2023
  Time: 08:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
    if(session.getAttribute("retailerId") == null){
        response.sendRedirect("loginRetailer.jsp");
    }
%>
<html>
<head>
    <title>Kategori Ekle</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Kategori Ekleme Ekranı</div>
        <div class="card-body">
            <form action="add-category" method="POST">
                <div class="form-group">
                    <label for="exampleInputCategoryName">Kategori Adı</label>
                    <input name="categoryName" type="text" class="form-control" id="exampleInputCategoryName" placeholder="Kategori Adınız Giriniz" required>
                </div>
                <div class="text-center mt-2">
                    <button type="submit" class="btn btn-primary" id="btn-submit">Kategori Ekle</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>

