<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tip creation</title>

</head>
<body>

	<jsp:include page="common/header.jsp"/>


	<div class="container">

		<%
		if (session.getAttribute("username") != null) {
		%>

		<div class="col-md-12 col-md-offset-3">

			<%
				String success = (String)request.getAttribute("success");
			%>
			<h2>Tip creation</h2>

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

			<form action="<%=request.getContextPath()%>/tip?target=create" method="post">

				<div class="form-group">
					<label for="title">Title:</label> <input type="text"
						class="form-control" id="title" placeholder="Title" name="title"
						required>
				</div>

				<div class="form-group">
					<label for="description">Description:</label> <input type="text"
						class="form-control" id="description" placeholder="Description"
						name="description" required>
				</div>

				<div class="form-group">
					<label for="exampleHtmlEscape">Example:</label>
					<textarea class="form-control" id="exampleHtmlEscape" rows="3"
						placeholder="Example HTML" name="exampleHtmlEscape" required></textarea>
				</div>



				<button type="submit" class="btn btn-primary">Submit</button>

			</form>

		</div>
		<%
		}
		%>
	</div>




	<jsp:include page="common/footer.jsp"/>

</body>
</html>