<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>
    <body>
        <h1 class="text-center">Welcome to User Form</h1>
        <h3>Username: ${userResult.username}</h3>
        <h3>Password: ${userResult.password}</h3>
        <h3>Country: ${userResult.country}</h3>
        <h3>Preferred Programming Language: ${userResult.programmingLanguage}</h3>
        <h3>Preferred Operating System(s): ${userResult.operatingSystems}</h3>
    </body>
</html>