<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: theara
  Date: 20/2/23
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Tip</title>
</head>
<body>
<jsp:include page="common/header.jsp"/>

<div class="container">
    <div class="row">
        <h2>Update tip</h2>
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
            <form action="<%=request.getContextPath()%>/tip?target=edit&id=<%=request.getParameter("id")%>" method="post">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text"
                           class="form-control" id="title" value="<%=request.getAttribute("title")%>" name="title"
                           required>
                </div>

                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text"
                           class="form-control" id="description" value="<%=request.getAttribute("description")%>" name="description"
                           required>
                </div>

                <div class="form-group">
                    <label for="exampleHtmlEscape">Example Html Escape:</label>
                    <input type="text"
                           class="form-control" id="exampleHtmlEscape" value="<%=request.getAttribute("exampleHtmlEscape")%>" name="exampleHtmlEscape"
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
