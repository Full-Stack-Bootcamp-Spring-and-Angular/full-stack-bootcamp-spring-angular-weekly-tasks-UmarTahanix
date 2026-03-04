<html>
    <head>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

        <%--        import Bootstrap--%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    </head>
    <body background="${pageContext.request.contextPath}/resources/images/background.jpg">
        <form action="processForm">
            <input type="text" placeholder="Year..." name="year"/>
            <br>
            <input type="text" placeholder="Month..." name="month"/>
            <br>
            <input type="text" placeholder="Day..." name="day"/>
            <br>
            <input type="submit" class="btn btn-primary">
        <form>
    </body>
</html>