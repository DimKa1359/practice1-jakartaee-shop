<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
    <h2>Products</h2>
    <ul>
        <c:forEach items="${products}" var="product">
            <li>${product.id}: ${product.name} - ${product.price} (Category: ${product.category.name})</li>
        </c:forEach>
    </ul>

    <h3>Add Product</h3>
    <form method="post">
        <input type="text" name="name" placeholder="Product name" required />
        <input type="number" step="0.01" name="price" placeholder="Price" required />
        <input type="number" name="category_id" placeholder="Category ID" required />
        <input type="submit" value="Add" />
    </form>
</body>
</html>