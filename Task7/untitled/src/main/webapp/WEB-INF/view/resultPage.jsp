<html>
<head>
    <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h1>Hello to Employee Registration App</h1>
    <h3>Username is : ${employeeResult.username} </h3>
    <h3>Email is : ${employeeResult.email} </h3>
    <h3>Password is : ${employeeResult.password} </h3>
</body>
</html>


