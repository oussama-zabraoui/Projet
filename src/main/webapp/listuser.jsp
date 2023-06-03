<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>list des utilisateur  </title>
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
       
      <h1>Liste des utilisateurs</h1>  
    </div>
   
  </div>


  <div class="container">
 
    <p>Les information des utilisateurs :</p>            
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Nom</th>
          <th>Prenom</th>
          <th>email</th>
          <th>mot de passe</th>
          <th>role</th>
          <th>Modifier</th> 
          <th>Supprimer</th>
        </tr>
      </thead>
    
      
      
  
       <tbody>
     <c:forEach items="${AllList}" var="all">  
        <tr>
          <td>${all.getNom()}</td>
          <td>${all.getPrenom()}</td>
          <td>${all.getEmail()}</td>
          <td>${all.getMot_de_passe()}</td>
          <td>${all.getRole()}</td>
          <td><form action="UserModifier" method="post">
          <input type="hidden" name="nom"  class="form-control" value="${all.getNom()}">
          <input type="hidden" name="prenom"  class="form-control" value="${all.getPrenom()}">
          <input type="hidden" name="email"  class="form-control" value="${all.getEmail()}">
          <input type="hidden" name="mot_de_passe"  class="form-control" value="${all.getMot_de_passe()}">
          <input type="hidden" name="role"  class="form-control" value="${all.getRole()}">
          <input type="submit" value="Modifier" class="btn btn-success btn-lg pull-left">
          </form></td>
          <td><form action="UtilisateurSupprimer" method="get">
          <input type="hidden" name="nom"  class="form-control" value="${all.getNom()}">
          <input type="hidden" name="prenom"  class="form-control" value="${all.getPrenom()}">
          <input type="hidden" name="email"  class="form-control" value="${all.getEmail()}">
          <input type="hidden" name="mot_de_passe"  class="form-control" value="${all.getMot_de_passe()}">
          <input type="hidden" name="role"  class="form-control" value="${all.getRole()}">
          <input type="submit" value="Supprimer" class="btn btn-danger btn-lg pull-left">
          </form></td>
          
        </tr>
      </tbody>
       </c:forEach>
    </table>
    <a class="btn btn-info btn-lg" href="Ajouteruser.jsp" role="button" >Ajouter utilisateur</a>
  </div>
  
 
  