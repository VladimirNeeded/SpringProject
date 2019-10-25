<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vohat
  Date: 05.06.2019
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>

    <div>
        <c:forEach var="c" items="${categories}">
            <h3>Category name <a href="<c:url value="/products?c_id=${c.id}"/>"><c:out value="${c.name}"/></a></h3>
            <H4>Category description: <c:out value="${c.description}"/></H4>
            <a href="<c:url value="/edit-category?c_id=${c.id}"/>">Edit</a>
            <a href="<c:url value="/delete-category?c_id=${c.id}"/>">Delete</a>
        </c:forEach>
    </div>

    <div>
        <H3> Add category </H3>
        <a href="<c:url value="/add-category"/>">ADD</a>
    </div>

</body>
</html>