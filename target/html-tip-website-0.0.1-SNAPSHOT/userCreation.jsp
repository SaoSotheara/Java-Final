<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: theara
  Date: 20/2/23
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<jsp:include page="common/header.jsp"/>

    <div class="container">
        <div class="row">
            <h2>User creation</h2>
        </div>
        <%
            String success = (String)request.getAttribute("success");
        %>

        <c:choose>
            <c:when test="<%=success != null%>">
                <div class="col-md-12 col-md-offset-3">
                    <div class="alert alert-success center" role="alert">
                        <p><%=success%></p>
                    </div>
                </div>
            </c:when>
            <c:when test="${error}">
                <div class="col-md-12 col-md-offset-3">
                    <div class="alert alert-success center" role="alert">
                        <p>${error}</p>
                    </div>
                </div>
            </c:when>
        </c:choose>
        <div class="row">
            <div class="col-12">
                <form action="<%=request.getContextPath()%>/user?target=insert" method="POST">
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text"
                               class="form-control" id="username" placeholder="username" name="username"
                               required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="text"
                               class="form-control" id="password" placeholder="password" name="password"
                               required>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>

                </form>
            </div>
        </div>
    </div>

<jsp:include page="common/footer.jsp"/>

</body>
</html>
