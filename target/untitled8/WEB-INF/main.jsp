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
    <title>Document</title>
</head>
<body>
<h2>Books</h2>
<table class="table-sortable">
    <thead>
    <tr>
        <c:if test="${requestScope.fields.id}">
            <th>id</th>
        </c:if>
        <c:if test="${requestScope.fields.author}">
            <th>author</th>
        </c:if>
        <c:if test="${requestScope.fields.title}">
            <th>title</th>
        </c:if>
        <c:if test="${requestScope.fields.genre}">
            <th>genre</th>
        </c:if>
        <c:if test="${requestScope.fields.cover}">
            <th>cover</th>
        </c:if>
        <c:if test="${requestScope.fields.year}">
            <th>year</th>
        </c:if>
        <c:if test="${requestScope.fields.description}">
            <th>description</th>
        </c:if>
        <th>
            <button class="backButton" onclick="location.href='${pageContext.request.contextPath}/addBook'" type="button">Добавить</button>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${requestScope.bookList}">
        <tr onclick="location.href='${pageContext.request.contextPath}/description?id=${book.id}'">
            <c:if test="${requestScope.fields.id}">
                <td><c:out value="${book.id}"/></td>
            </c:if>
            <c:if test="${requestScope.fields.author}">
                <td><c:out value="${book.author}"/></td>
            </c:if>
            <c:if test="${requestScope.fields.title}">
                <td><c:out value="${book.title}"/></td>
            </c:if>
            <c:if test="${requestScope.fields.genre}">
                <td><c:out value="${book.genre}"/></td>
            </c:if>
            <c:if test="${requestScope.fields.cover}">
                <td>
                    <img src="${book.coverUrl}" alt="cover"/>
                </td>
            </c:if>
            <c:if test="${requestScope.fields.year}">
                <td><c:out value="${book.year}"/></td>
            </c:if>
            <c:if test="${requestScope.fields.description}">
                <td><c:out value="${book.description}"/></td>
            </c:if>
            <td>
                <form action="${pageContext.request.contextPath}/deleteBook" method="post">
                    <input type="hidden" name="id" value="${book.id}">
                    <button class="backButton" type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
