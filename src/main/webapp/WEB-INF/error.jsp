<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 10/25/2021
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1 style="color: red"><c:out value="${requestScope.errorMessage}"/></h1>
    <button class="backButton" onclick="location.href='${pageContext.request.contextPath}/'" type="button">Назад</button>
</body>
</html>
