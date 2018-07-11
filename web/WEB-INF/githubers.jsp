<%--
  Created by IntelliJ IDEA.
  User: wilders
  Date: 09/07/18
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../header.jsp"></jsp:include>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Githubers</title>
</head>
<body>
<h1>Liste des githubers</h1>

<div class="container-fluid">

    <div class="row">
        <div class="col-sm-4">
            <c:forEach items="${githubers}" var="githuber">
                <div class="thumbnail">
                    <div><img src="<c:out value="${githuber.avatarUrl}/${githuber.login}" />" alt="github avatar"
                              style="width: 100px;height: 100px;"></div>
                    <div class="caption">
                        <h2><c:out value="${githuber.name}"/></h2>
                        <h4>ID : <c:out value="${githuber.id}"/></h4>
                        <h4>Email : <c:out value="${githuber.email}"/></h4>
                        <h4>Login : <c:out value="${githuber.login}"/></h4>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
