<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
    <h2>Categories</h2>
    <ul>
        <c:forEach items="${categories}" var="category">
            <li>${category.id}: ${category.name}</li>
        </c:forEach>
    </ul>

    <h3>Add Category</h3>
    <form method="post">
        <input type="text" name="name" placeholder="Category name" required />
        <input type="submit" value="Add" />
    </form>
</body>
</html>