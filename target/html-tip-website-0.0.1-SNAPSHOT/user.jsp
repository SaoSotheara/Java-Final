<%@ page import="com.itstep.htmltip.entity.Admin" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: theara
  Date: 19/2/23
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>

    <jsp:include page="common/header.jsp"/>

    <div class="container">
        <div class="row pt-5">
            <div class="col-10"></div>
            <div class="col-2">
                <a href="<%= request.getContextPath() %>/user?target=creation" class="btn btn-primary">Create User</a>
            </div>
        </div>
        <div class="row">
            <div class="col-12 pt-5">
                <table class="table table-striped" style="text-align: center">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Admin> users = (List<Admin>) request.getAttribute("users");
                        if (users != null) {
                            for(Admin user: users) {
                    %>
                    <tr>
                        <td><%=user.getId()%></td>
                        <td><%=user.getUsername()%></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?target=delete&id=<%=user.getId()%>"><i class="bi bi-trash"></i></a>
                            <a href="<%=request.getContextPath()%>/user?target=edit&id=<%=user.getId()%>"><i class="bi bi-trash"></i></a>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <jsp:include page="common/footer.jsp"/>

</body>
</html>
