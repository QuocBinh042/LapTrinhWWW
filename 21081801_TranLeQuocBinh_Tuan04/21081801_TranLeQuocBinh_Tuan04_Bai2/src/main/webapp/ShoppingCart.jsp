<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-4">
        <a href="ModelList" class="btn btn-primary mb-4">Product List</a>

        <c:if test="${not empty sessionScope.successMessage}">
            <div class="alert alert-success" role="alert">
                ${sessionScope.successMessage}
            </div>
            <c:set var="successMessage" scope="session" value=""/>
        </c:if>

        <table class="table table-bordered">
            <thead class="table-light">
                <tr>
                    <th>Model Description</th>
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${empty cartItems}">
                    <tr>
                        <td colspan="4" class="text-center">Cart is currently empty.</td>
                    </tr>
                </c:if>

                <c:forEach items="${cartItems}" var="cartItem" varStatus="counter">
                    <tr>
                        <td>${cartItem.partNumber}<br/>${cartItem.modelDescription}</td>
                        <td>
                            <form name="item" method="POST" action="CartController" class="d-flex">
                                <input type="hidden" name="itemIndex" value="${cartItem.id}">
                                <input type="text" name="quantity" value="${cartItem.quantity}" size="2" class="form-control w-50 me-2">
                                <button type="submit" name="action" value="update" class="btn btn-warning btn-sm me-2">Update</button>
                                <button type="submit" name="action" value="delete" class="btn btn-danger btn-sm">Delete</button>
                            </form>
                        </td>
                        <td>$ ${cartItem.unitCost}</td>
                        <td>$ ${cartItem.totalCost}</td>
                    </tr>
                </c:forEach>
                
                <tr>
                    <td colspan="2"></td>
                    <td><strong>Subtotal</strong></td>
                     <td><strong>$ ${cartTotal}</strong></td>
                </tr>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
