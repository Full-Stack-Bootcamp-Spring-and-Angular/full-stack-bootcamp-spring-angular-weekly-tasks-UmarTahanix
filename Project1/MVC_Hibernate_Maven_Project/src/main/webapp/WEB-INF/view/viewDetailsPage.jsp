<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%--        import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

</head>
<body>
    <h1>Product Details:</h1>
    <h3>Product ID: ${productDetails.id}</h3>
    <h3>Product Name: ${productDetails.name}</h3>
    <h3>Product Expiration Date: ${productDetails.expirationDate}</h3>
    <h3>Product Manufacturer: ${productDetails.manufacturer}</h3>
    <h3>Product Price: ${productDetails.price}</h3>
    <h3>Product Availability (0:No, 1:Yes): ${productDetails.available}</h3>
    <br>
    <form action="viewBackHome">
        <input type="submit" class="btn btn-primary" value="Back">
    </form>
</body>

</html>