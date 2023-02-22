<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>HTML Tips</title>

<meta charset="ISO-8859-1">
<title>Login</title>

</head>
<body>
	<jsp:include page="common/header.jsp"/>


	<div class="container">

		<h2>Login for Admin only</h2>

		<div class="col-md-12 col-md-offset-3">

            <%
                String fail = (String)request.getAttribute("fail");
                String success = (String)request.getAttribute("success");
            %>

            <c:if test="<%=fail != null%>">
                <div class="alert alert-danger center" role="alert">
                    <p><%=fail%></p>
                </div>
            </c:if>
            <c:if test="<%=success != null%>">
                <div class="alert alert-success center" role="alert">
                    <p><%=success%></p>
                </div>
            </c:if>

			<form action="<%=request.getContextPath()%>/login" method="post">

				<div class="form-group">
					<label for="username">User Name:</label>
                    <input type="text"
						class="form-control" id="username" placeholder="User Name"
						name="username" required>
				</div>

				<div class="form-group">
					<label for="password">Password:</label>
                    <input type="password"
						class="form-control" id="password" placeholder="Password"
						name="password" required>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>

			</form>
		</div>
	</div>




	<jsp:include page="common/footer.jsp"/>
</body>
</html>