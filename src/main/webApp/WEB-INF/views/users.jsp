<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vohat
  Date: 24.06.2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h2>All users: </h2>

<c:forEach var="u" items="${users}">
    <h3>Name: <c:out value="${u.firstName}"/></h3>
    <h3>Surname: <c:out value="${u.lastName}"/></h3>
    <h5>Roles: <c:forEach var="r" items="${u.getRoles()}">
        <c:out value="${r.name}"/>
    </c:forEach> </h5>
</c:forEach>


</body>
</html>
