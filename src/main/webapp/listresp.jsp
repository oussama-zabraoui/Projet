<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>list responsable  </title>
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



<div class="container">
    <div class="jumbotron">
       
      <h1>Liste des responsables</h1>  
    </div>
   
  </div>


  <div class="container">
 
    <p>Les information des responsables :</p>            
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Nom de responsable</th>
          <th>Matricule responsable</th>
          <th>Modifier</th>
        </tr>
      </thead>
    
      
      
  
       <tbody>
     <c:forEach items="${AllRespo}" var="re">  
        <tr>
          <td>${re.getNom_responsable()}</td>
          <td>${re.getMatricule_responble()}</td>
          <td><form action="Editresponsable" method="post">
          <input type="hidden" name="nomr"  class="form-control" value="${re.getNom_responsable()}" >
          <input type="hidden" name="matr"  class="form-control" value="${re.getMatricule_responble()}" >
          <input type="submit" value="Modifier" class="btn btn-success btn-lg pull-left">
          
          </form></td> 
        </tr>
      </tbody>
       </c:forEach>
    </table>
    <a class="btn btn-info btn-lg" href="responsable.jsp" role="button" >Ajouter Responsable</a>
  </div>
  
 
  
  
  
      
  
  
  
  




</body>
</html>