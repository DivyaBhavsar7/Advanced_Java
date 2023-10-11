<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.helper.*,org.hibernate.*,com.entities.*" %>
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
   <h1>Edit your Note</h1>
   <%
   int noteid=Integer.parseInt(request.getParameter("note_id").trim());
   
   Session s=FactoryProvider.getfactory().openSession();
   Note note=(Note)s.get(Note.class, noteid);
   %>
   <!-- Add form -->
   <form action="editServlet" method="post">
   <input value="<%=note.getId()%>" name="noteid" type="hidden">
  <div class="form-group">
    <label for="title">Title</label>
    <input required 
    name="title"
    type="text" 
    class="form-control" 
    id="title" 
    aria-describedby="emailHelp" 
    placeholder="Enter here"
    value="<%=note.getTitle() %>">
    
  </div>
  <div class="form-group">
    <label for="NoteContent">Note Content</label>
    <textarea required
    name="content"
    id="content" 
    placeholder="Enter Your Content Here"
    class="form-control"
    style="height: 300px "><%=note.getContent() %>
    </textarea>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Update</button>
  </div>
  
</form>
   </div>
</body>
</html>