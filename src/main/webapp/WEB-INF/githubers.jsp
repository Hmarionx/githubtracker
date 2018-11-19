<%--
  Created by IntelliJ IDEA.
  User: wilders
  Date: 09/07/18
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
                    <div class="caption">
                        <div><img src="<c:out value="${githuber.avatar_url}" />" alt="github avatar"
                                  style="width: 220px;height: 220px;"></div>
                        <h2><c:out value="${githuber.name}"/></h2>
                        <h4>ID : <c:out value="${githuber.github_id}"/></h4>
                        <h4>Email : <c:out value="${githuber.email}"/></h4>
                        <h4>Login : <c:out value="${githuber.login}"/></h4>
                        <h4>Bio : <c:out value="${githuber.bio}"/></h4>
                        <h4>Location : <c:out value="${githuber.location}"/></h4>
                        <h4>Viens voir mon <a href="<c:out value='${githuber.html_url}' />">github</a>...</h4>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
