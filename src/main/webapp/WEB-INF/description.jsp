<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><c:out value="${requestScope.book.title}"/></title>
</head>
<body>
<div class="descriptionBook">
    <p class="title"><c:out value="${requestScope.book.title}"/></p>
    <p class="author"><c:out value="${requestScope.book.author}"/></p>
    <p class="genre"><c:out value="${requestScope.book.genre}"/></p>
    <p class="year"><c:out value="${requestScope.book.year}"/></p>
    <p class="description"><c:out value="${requestScope.book.description}"/></p><img src="${requestScope.book.coverUrl}"/>
    <button class="backButton" onclick="location.href='${pageContext.request.contextPath}/'" type="button">Назад</button>
</div>
</body>
</html>
