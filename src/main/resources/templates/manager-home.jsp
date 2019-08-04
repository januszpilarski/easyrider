<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Manager Home Page</title>
</head>
<body>

<h2>Menedżer</h2>
Hi

<hr>

<a href="${pageContext.request.contextPath}/">powrot do glownej</a>

<hr>

<!-- logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="POST">

    <input type="submit" value="Logout">

</form:form>
</body>
</html>