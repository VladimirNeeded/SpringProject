<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vohat
  Date: 22.06.2019
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>

    <div>
        <c:forEach var="p" items="${products}">
            <H3>Product name: <c:out value="${p.name}"/></H3>
            <H4>Product description: <c:out value="${p.description}"/></H4>
            <H4>Product price: <c:out value="${p.price}"/></H4>
        </c:forEach>
    </div>

</body>
</html>
