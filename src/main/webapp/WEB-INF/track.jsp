<%--
  Created by IntelliJ IDEA.
  User: wilders
  Date: 03/09/18
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../header.jsp"></jsp:include>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tracker</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/track" enctype="application/x-www-form-urlencoded" method="post">
    <label>Login Github à rechercher:</label>
    <input name="login" type="text">
    <button type="submit">Trouve-moi ce Githuber !</button>
</form>
</body>
</html>
