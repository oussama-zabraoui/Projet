<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>Add projet</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<%  if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}



%>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="projet.jsp">PPAP</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
      <ul class="nav navbar-nav navbar-right">
          <li><a href="projet.jsp">Projet</a></li>
        <li><a href="client.jsp">Client</a></li>
        <li><a href="responsable.jsp">Responsable</a></li>
        <li><a href="equipe.jsp">Equipe</a></li>
        
       <% if(session.getAttribute("email")!=null){
       if(session.getAttribute("role").equals("admin")){ %> 
        <li><a href="Rlistutilisateurs">Utilisateurs</a></li>
        <%} }%>
        <li><a href="logout"><img src="css/se-deconnecter.png" ></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<%@ page import="java.sql.*" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.*" %>
<%@ page import="bussnissLayer.Requestimpl" %>
<%

Requestimpl req=new Requestimpl();
ArrayList<String> listc =req.getClient();
System.out.println(listc);
request.setAttribute("listc", listc);

%>






<div class="container">
 <p>Les information des projet :</p>            
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Nom de projet</th>
          
        </tr>
      </thead>   
  
       <tbody>
       
     <c:forEach  items="${listc}" var="cl">  
        <tr>
          <td>${cl}</td>
       
        
          
        </tr>
        
        
      </tbody>
       </c:forEach>
    </table>
    <a class="btn btn-info btn-lg" href="projet.jsp" role="button" >Ajouter Projet</a>
</div>


</body>
</html> 