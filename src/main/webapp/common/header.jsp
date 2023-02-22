<header>
 <nav class="navbar navbar-expand-md navbar-dark"
  style="background-color: #2596be;">
  <div>
   <a href="<%= request.getContextPath() %>/" class="navbar-brand"> HTML Tips</a>
  </div>

  <ul class="navbar-nav navbar-collapse justify-content-end">
   <%if (session.getAttribute("username")!= null){ %>
   <li><a href="<%= request.getContextPath() %>/logout" class="nav-link">Logout</a></li>
   <li><a href="<%= request.getContextPath() %>/tip?target=creation" class="nav-link">Create Tip</a></li>
   <li><a href="<%= request.getContextPath() %>/user" class="nav-link">User</a></li>
   <%} else {%>
   
   <%} %>
   
   
  </ul>
 </nav>
 <link rel="stylesheet"
       href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
       integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
       crossorigin="anonymous">
</header>