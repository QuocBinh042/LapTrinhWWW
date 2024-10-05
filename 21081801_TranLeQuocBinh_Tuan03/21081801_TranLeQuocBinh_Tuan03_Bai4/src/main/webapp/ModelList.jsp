<jsp:useBean id="product" scope="session" class="bai4.beans.ProductList" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            padding: 20px;
            margin: 0;
        }

        .container {
            width: 100%;
            max-width: 900px;
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .product {
            flex: 0 0 calc(33.33% - 20px);
            margin: 10px;
            text-align: center;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 15px;
            background-color: #f9f9f9;
            box-sizing: border-box;
        }

        .product:hover {
            transform: scale(1.02);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
        }

        img {
            width: 150px;
            height: 200px;
            border-radius: 5px;
        }

        .price {
            font-weight: bold;
            margin: 10px 0;
            color: #0078d7;
        }

        input[type="text"] {
            width: 60px;
            margin: 5px 0;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 8px 12px;
            background-color: #0078d7;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #005bb5;
        }

        .view-cart {
            width: 100%;
            text-align: left;
            margin-bottom: 10px;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="view-cart">
            <a href="ShoppingCart">View Cart</a>
        </div>
        <c:forEach items="${ds}" var="sp"> 
            <div class="product">
                <form action="CartController" method="POST">
    <p>${sp.model}</p>
    <img src="${sp.imgURL}" class="img" alt="${sp.model}">
    <div class="price">Price: ${sp.price}</div>
    <input type="text" size="2" value="1" name="quantity">
    <input type="hidden" name="modelNo" value="${sp.id}">
    <input type="hidden" name="price" value="${sp.price}">
    <input type="hidden" name="description" value="${sp.model}">
    <input type="hidden" name="action" value="add">
    <input type="submit" value="Add To Cart">
</form>
            </div>
        </c:forEach>
    </div>
</body>

</html>