<%--
  Created by IntelliJ IDEA.
  User: wilders
  Date: 13/11/18
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../header.jsp"></jsp:include>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UnTracker</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/untrack" enctype="application/x-www-form-urlencoded" method="post">
    <label>Login Github à retirer : </label>
    <input name="login" type="text">
    <button type="submit">Retirer ce githuber de la base</button>
</form>
</body>
</html>
