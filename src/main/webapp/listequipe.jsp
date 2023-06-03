<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>list equipe  </title>
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
       
      <h1>Liste des equipe</h1>  
    </div>
   
  </div>


  <div class="container">
 
    <p>Les information des equipe :</p>            
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Nom equipe</th>
          <th>Matricule equipe</th>
          <th>Matricule responsable</th>
          <th>Nom responsable</th>
          <th>Modifier</th>
      
        </tr>
      </thead>
    
      
      
  
       <tbody>
       
     <c:forEach items="${AllEquipe}" var="eqi">  
        <tr>
          
          <td>${eqi.getId_equipe()}</td>
          <td>${eqi.getNom_equipe()}</td>
          <td>${eqi.getId_responsable()}</td>
          <td>${eqi.getResponsable().getNom_responsable()}</td>
          <td><form action="Editequipe" method="post">
          <input type="hidden" name="mateq"  class="form-control" value="${eqi.getId_equipe()}" >
          <input type="hidden" name="nomeq"  class="form-control" value="${eqi.getNom_equipe()}" >
          <input type="hidden" name="matree"  class="form-control" value="${eqi.getId_responsable()}" >
          <input type="submit" value="Modifier" class="btn btn-danger btn-lg pull-left">
          
          </form>
          </td>
        </tr>
      </tbody>
       </c:forEach>
    </table>
    <a class="btn btn-info btn-lg" href="equipe.jsp" role="button" >Ajouter equipe</a>
  </div>
  
  
  
  
      
  





</body>
</html>