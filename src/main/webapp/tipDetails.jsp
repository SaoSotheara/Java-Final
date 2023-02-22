<%@page import="com.itstep.htmltip.entity.Tip"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		Tip tip = (Tip) request.getAttribute("tip");
		String[] htmlList = tip.getExampleHtmlEscape().split("[\\r\\n]+");
		%>

		<div class="row pt-5">
			<%if (session.getAttribute("username")!= null){ %>
			<div class="col-10"></div>
			<div class="col-2">
				<a href="<%= request.getContextPath() %>/tip?target=update&id=<%=tip.getTipId()%>" class="btn btn-primary">Update Tip</a>
			</div>
			<%
				}
			%>
		</div>

		<div class="overflow-auto">
			<div class="card w-85 mt-3">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title"><%=tip.getTitle()%></h5>
						<p class="card-text"><%=tip.getDescription()%></p>
						<h5 class="card-title">Example</h5>
						<p class="card-text"><%=tip.getExampleHtmlEscape()%></p>
						<p class="card-text">
							<c:forEach var="item" items="<%=htmlList%>">
								<br>
								<code>
									<c:out value="${item}" escapeXml="true"/>
								</code>
							</c:forEach>

						</p>
					</div>
				</div>

			</div>
		</div>



	</div>




	<jsp:include page="common/footer.jsp"/>

</body>
</html>