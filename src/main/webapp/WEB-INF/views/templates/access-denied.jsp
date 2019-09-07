<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access-denied</title>
</head>
<body>

    <h2>Access-denied</h2>

    <hr>

    <a href="${pageContext.request.contextPath}/">powrot do glownej</a>

    <hr>

    <!-- logout button -->
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">

        <input type="submit" value="Logout">

    </form:form>

</body>
</html>
