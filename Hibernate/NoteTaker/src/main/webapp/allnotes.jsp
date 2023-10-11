<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@include file="All_js_css.jsp" %>
</head>
<body>
<div class="container-fluid">
<%@include file="navbar.jsp" %>
<br>
<h1>All Notes</h1>
<br>
<div class="row">
<div class="col-12">
<%
Session s=FactoryProvider.getfactory().openSession();
Query q=s.createQuery("from Note");
List<Note> list=q.list();
for(Note a : list)
{
	%>
	<div class="card mt-3" >
  <img class="card-img-top m-4 mx-auto" style="max-width:100px" src="img/notes.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title"><%=a.getTitle() %></h5>
    <p class="card-text"><%=a.getContent() %></p>
    <p>Last Updated on :<b><%=a.getAddeddate() %></b></p>
    
   <div class="container text-center mt-2">
    <a href="edit.jsp?note_id=<%=a.getId() %>" class="btn btn-primary">Edit</a>
    <a href="deleteServlet?note_id=<%=a.getId() %>" class="btn btn-danger">Delete</a>
    </div>
  </div>
</div>
	
	<%
}

s.close();
%>
</div>

</div>

</div>
</body>
</html>