<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>list des éléments </title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

<%

Object part_number = request.getAttribute("part_number");

%>

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
       
      <h1>Liste des éléments</h1>  
    </div>
   
  </div>


  <div class="container">
 
    <p>Les information des éléments :</p>            
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Nom de l'élment</th>
          <th>Date de début</th>
          <th>Date de fin</th>
          <th>Statut</th>
          <th>Numero de projet</th>
          <th>Matricule de l'équipe</th>
          <th>Nom de l'équipe</th>
          <th>Nom de responsable</th>
          <th>Matricule de responsable</th>
          <th>Ajouter document</th>
          <th>List des documents</th>
          <th>Modifier</th>
        </tr>
      </thead>
    
      
      
  
       <tbody>
       
     <c:forEach items="${AllElement}" var="ele">  
        <tr>
          
          <td>${ele.getName_element()}</td>
          <td>${ele.getDate_debut()}</td>
          <td>${ele.getDate_fin()}</td>
          <td>${ele.getStatu_element()}</td>
          <td>${ele.getPart_number()}</td>
          <td>${ele.getId_equipe()}</td>
          <td>${ele.getP().getNom_equipe()}</td>
          <td>${ele.getR().getNom_responsable()}</td>
          <td>${ele.getR().getMatricule_responble()}</td>
          <td><form action="Refdocument" method="post">
          <input type="hidden" name="nomelement" value="${ele.getName_element()}"  >
          <input type="hidden" name="partn"  class="form-control" value="${ele.getPart_number()}" >
          <input type="submit" value="Ajouter document" class="btn btn-success btn-lg pull-left">
          </form></td>
          
          <td><form action="Rlistdocument" method="get">
          <input type="hidden" name="nomelement" value="${ele.getName_element()}"  >
          <input type="hidden" name="partn"  class="form-control" value="${ele.getPart_number()}" >
          <input type="submit" value="list des documents" class="btn btn-warning btn-lg pull-left">
          </form></td>
          
          <td><form action="Editelement" method="post">
     <input type="hidden" name="nomelement" value="${ele.getName_element()}"  >
     <input type="hidden" name="dated" value="${ele.getDate_debut()}"  >
     <input type="hidden" name="datef"  value="${ele.getDate_fin()}" >
     <input type="hidden" name="etat" value="${ele.getStatu_element()}" >
     <input type="hidden" name="mateq"value="${ele.getId_equipe()}" >
    <input type="hidden" name="partn"  class="form-control" value="<%=part_number%>" >
     <input type="submit" value="Modifier element" class="btn btn-secondary btn-lg pull-left">
    </form></td>
        </tr>
      </tbody>
        </c:forEach>
    </table>
    
    <form action="ElementPartN" method="post">
    <input type="hidden" name="partn"  class="form-control" value="<%=part_number%>" >
     <input type="submit" value="Ajouter element" class="btn btn-info btn-lg pull-left">
    </form>
   
  </div>
  
</body>
</html>