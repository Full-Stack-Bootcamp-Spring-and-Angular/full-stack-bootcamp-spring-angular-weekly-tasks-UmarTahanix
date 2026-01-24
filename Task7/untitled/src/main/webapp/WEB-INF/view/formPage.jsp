<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

        <%--        import Bootstrap--%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    </head>
    <body background="${pageContext.request.contextPath}/resources/images/background.jpg">
        <h1>Employee registration Form</h1>
        <form:form action="processForm" modelAttribute="employee">
            <br>Username<br>
            <form:input type="text" placeholder="Enter Username..." path="username"/>
            <br>
            <form:errors id="error" path="username" cssClass="error"/>
            <br>
            Email address<br><form:input type="text" placeholder="Email..." path="email"/>
            <br>
            <form:errors id="error" path="email" cssClass="error"/>
            <br>
            Password<br><form:input type="password" placeholder="Password..." path="password"/>
            <br>
            <form:errors id="error" path="" cssClass="error"/>
            <br>
            Confirm Password<br><form:input type="password" placeholder="Confirm password..." path="confirmPassword"/>
            <br>
            <form:errors id="error" path="" cssClass="error"/>
            <br>
            <input type="submit" class="btn btn-primary">
        </form:form>
    </body>
</html>

