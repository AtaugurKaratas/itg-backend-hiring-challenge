<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ataugurkaratas
  Date: 12.01.2023
  Time: 05:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String auth = (String) session.getAttribute("auth");
    String retailerId = (String) session.getAttribute("retailerId");
    String supplierId = (String) session.getAttribute("supplierId");
    if (session.getAttribute("retailerId") == null) {
        response.sendRedirect("loginRetailer.jsp");
    }
%>
<html>
<head>
    <title>Title</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Ürün Ekleme Ekranı</div>
        <div class="card-body">
            <form action="add-product" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleInputProductName">Ürün Adı</label>
                    <input name="productName" type="text" class="form-control" id="exampleInputProductName"
                           placeholder="Ürün Adınız Giriniz" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPrice">Fiyatı</label>
                    <input name="price" type="text" class="form-control" id="exampleInputPrice"
                           placeholder="Ürün Fiyatını Giriniz" required>
                </div>
                <div class="form-group">
                    <label for="exampleSelectCategory">Kategori</label>
                    <select name="category" class="form-control" id="exampleSelectCategory">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="text-center mt-2">
                    <button type="submit" class="btn btn-primary" id="btn-submit">Ürün Ekle</button>
                </div>
                <div class="form-group">
                    <ul id="ulElement" style="list-style-type: none"></ul>
                </div>
            </form>
            <div class="text-start mt-2">
                <button class="btn btn-primary" id="btn-image-add">Ürün Resmi Ekle</button>
                <button class="btn btn-primary" id="btn-image-remove">Ürün Resmi Kaldır</button>
            </div>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
<script>
    let addImage = document.getElementById('btn-image-add');
    let removeImage = document.getElementById('btn-image-remove');
    let ulElement = document.getElementById('ulElement');
    let id = 0;
    addImage.onclick = () => {
        id++;
        let liElement = document.createElement('li');
        liElement.setAttribute('class', 'mt-2');
        liElement.setAttribute('id', "List" + id);
        ulElement.appendChild(liElement);

        let divElement = document.createElement('div');
        divElement.setAttribute('class', "form-group");
        divElement.setAttribute('id', "divElement" + id);
        liElement.appendChild(divElement);

        let labelElement = document.createElement('label');
        labelElement.setAttribute("for", "exampleInputImage" + id);
        labelElement.setAttribute("text", "Image " + id);
        divElement.appendChild(labelElement);

        let inputElement = document.createElement('input');
        inputElement.setAttribute("name", "file" + id);
        inputElement.setAttribute("type", "file");
        inputElement.setAttribute('class', 'form-control');
        inputElement.setAttribute("id", "exampleInputImage" + id);
        divElement.appendChild(inputElement);
    }

    removeImage.onclick = () => {
        if (id > 0) {
            let liElement = document.getElementById("List" + id);
            liElement.remove();
            id--;
        }
    }
</script>
</body>
</html>
