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
    <title>Добавь книгу</title>
</head>
<body>
<form class="addNewBook" action="${pageContext.request.contextPath}/addBook" method="post">
    <p>Введите название</p><input class="inputTitle" type="text" name="title">
    <p>Введите автора</p><input class="inputAuthor" type="text" name="author">
    <p>Введите жанр</p><input class="inputGenre" type="text" name="genre">
    <p>Введите год написания</p><input class="inputYear" type="number" name="year">
    <p>Введите описание</p><input class="inputDescription" type="text" name="description">
    <p>Введите ссылку на обложку</p><input class="inputCover" type="url" name="coverUrl">
    <button class="backButton" onclick="location.href='${pageContext.request.contextPath}/'" type="button">Назад</button>
    <button class="saveButton" type="submit">Сохранить</button>
</form>
</body>
</html>
