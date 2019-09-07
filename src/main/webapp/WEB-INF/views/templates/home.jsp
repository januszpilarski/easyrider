<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

    <head>
        <title>Title</title>
    </head>

        <h2> Company Home Page</h2>

        <hr>

        <p>
            User: <security:authentication property="principal.username"/>
                <br><br>
            Role(s) <security:authentication property="principal.authorities"/>
        </p>

        <hr>
    <security:authorize access="hasRole('ROLE_MANAGER')">

        <p>

            <a href="${pageContext.request.contextPath}/manager">
                Manager Home
            </a>

        </p>

    </security:authorize>
        <hr>

        <!-- logout button -->
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">

            <input type="submit" value="Logout">

        </form:form>

    </body>

</html>
