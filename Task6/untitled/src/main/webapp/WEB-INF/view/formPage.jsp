<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    </head>
    <body>
        <h1 class="text-center">User Form</h1>
        <div class="d-flex justify-content-center">
        <form:form action="processForm" modelAttribute="user">
            <form:input type="text" placeholder="username" path="username" />
            <br>
            <br>
            <form:input type="password" placeholder="password" path="password" />
            <br>
            <br>
            <form:select path="country">
                <form:option value="Egypt" label="EG" />
                <form:option value="Brazil" label="BR" />
                <form:option value="Saudi Arabia" label="SA" />
            </form:select>
            <br>
            <br>
            <p>Preferred Programming Language</p>
            Java <form:radiobutton path="programmingLanguage" value="Java" />
            C# <form:radiobutton path="programmingLanguage" value="C#" />
            PHP <form:radiobutton path="programmingLanguage" value="PHP" />
            Ruby <form:radiobutton path="programmingLanguage" value="Ruby" />
            <br>
            <br>
            <p>Preferred Programming Language</p>
            Linux <form:checkbox path="operatingSystems" value="Linux" />
            Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
            MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
            <br>
            <input type="submit" class="btn btn-danger">
        </form:form>
        </div>
    </body>
</html>