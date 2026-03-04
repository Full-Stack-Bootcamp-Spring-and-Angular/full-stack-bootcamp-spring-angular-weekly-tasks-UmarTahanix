<html>
    <head>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

        <%--        import Bootstrap--%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    </head>
    <body>
        <form action="processForm">
            <label>First Name</label>
            <br>
            <input type="text" placeholder="First name..." name="first_name"/>
            <br>
            <br>
            <label>Last Name</label>
            <br>
            <input type="text" placeholder="Last name..." name="last_name"/>
            <br>
            <br>
            <label>Email</label>
            <br>
            <input type="text" placeholder="Email..." name="email"/>
            <br>
            <br>
            <label>Date of Birth</label>
            <br>
            <input type="text" placeholder="Date of birth..." name="date_of_birth"/>
            <br>
            <br>
            <label>City</label>
            <br>
            <input type="text" placeholder="City..." name="city"/>
            <br>
            <br>
            <input type="submit" class="btn btn-primary">
        <form>
    </body>
</html>