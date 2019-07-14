<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <style>

        .failed {
            color: red;
        }

        .submit {
            color: darkblue;
        }

    </style>

</head>
<body> logowanie

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

    <!-- Check for login error -->
    <c:if test="${param.error != null}">
        <i class="failed"> wrong username/password </i>
    </c:if>

    <p class="submit">
        User name: <input type="text" name="username">
    </p>

    <p>
        Password: <input type="password" name="password">
    </p>

    <input type="submit" value="Login">

</form:form>

</body>
</html>
