<jsp:useBean id="cart" scope="session" class="bai4.beans.CartBean" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <title>Shopping Cart</title>
    <style>
		 body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            padding: 20px;      
        }

        .container {  
        	max-width: 900px;
            width: 100%;       
            height: 30%;        
            flex-wrap: wrap;
            justify-content: space-between;
            box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
        }
	</style>
</head>
<body>
    <div class="container">
        <p><a href="ModelList">Product List</a></p>
        
        <c:if test="${not empty sessionScope.successMessage}">
            <div class="alert alert-success">
                ${sessionScope.successMessage}
            </div>
            <c:set var="successMessage" scope="session" value=""/>
        </c:if>

        <table width="100%" border="1">
            <tr bgcolor="#cccccc">
                <td>Model Description</td>
                <td>Quantity</td>
                <td>Unit Price</td>
                <td>Total</td>
            </tr>
            
            <c:if test="${cart.lineItemCount == 0}">
                <tr>
                    <td colspan="4">Cart is currently empty <br></td>
                </tr>
            </c:if>
            
            <c:forEach items="${cart.cartItems}" var="cartItem" varStatus="counter">
                <tr>
                    <td>${cartItem.partNumber}<br />${cartItem.modelDescription}</td>
                    <td>
                        <form name="item" method="POST" action="CartController">
                            <input type="hidden" name="itemIndex" value="${counter.index}">
                            <input type="text" name="quantity" value="${cartItem.quantity}" size="2">
                            <input type="submit" name="action" value="update">
                            <input type="submit" name="action" value="delete">
                        </form>
                    </td>
                    <td>$ ${cartItem.unitCost}</td>
                    <td>$ ${cartItem.totalCost}</td>
                </tr>
            </c:forEach>
            
            <tr>
                <td colspan="2"></td>
                <td></td>
                <td>Subtotal $${cart.orderTotal}</td>
            </tr>
        </table>
    </div>
</body>
</html>
