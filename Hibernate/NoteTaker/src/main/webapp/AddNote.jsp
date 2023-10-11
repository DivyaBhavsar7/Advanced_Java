<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="All_js_css.jsp" %>
</head>
<body>
   <div class="container-fluid">
   <%@include file="navbar.jsp" %>
   <h1>Add your Note Details</h1>
   <br>
    
   <!-- Add form -->
   <form action="SaveNoteServlet" method="post">
  <div class="form-group">
    <label for="title">Title</label>
    <input required 
    name="title"
    type="text" 
    class="form-control" 
    id="title" 
    aria-describedby="emailHelp" 
    placeholder="Enter here">
  </div>
  <div class="form-group">
    <label for="NoteContent">Note Content</label>
    <textarea required
    name="content"
    id="content" 
    placeholder="Enter Your Content Here"
    class="form-control"
    style="height: 300px "
    ></textarea>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-primary">Add</button>
  </div>
  
</form>
   </div>
</body>
</html>