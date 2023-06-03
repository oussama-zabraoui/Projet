<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List projet</title>
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
       
      <h1>Liste des projet</h1>  
    </div>
   
  </div>


  <div class="container">
 
    <p>Les information des projet :</p>            
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Nom de projet</th>
          <th>Part Name</th>
          <th>Part Number</th>
          <th>Drawing</th>
          <th>Date de soumission</th> 
          <th>Delai de projet</th>
          <th>Statu PPAP</th>
          <th>Number de client</th>
          <th>Prenom de client</th>
          <th>Nom de client</th>
          <th>Voir</th>
          <th>Graphe</th>
          <th>Modifier</th>
          
        </tr>
      </thead>   
  
       <tbody>
       
     <c:forEach  items="${AllProjet}" var="pro">  
        <tr>
          <td>${pro.getNom_projet()}</td>
          <td>${pro.getPart_name()}</td>
          <td>${pro.getPart_number()}</td>
          <td>${pro.getDrawing()}</td>
          <td>${pro.getDate_soumission()}</td> 
          <td>${pro.getDelai_projet()}</td>
          <td>${pro.getStatu_PPAP()}</td>
          <td>${pro.getPart_n()}</td>
          <td>${pro.getC().getPrenom()}</td>
          <td>${pro.getC().getNom()}</td>
          <td><form action="ElementPartN" method="post">
          <input type="hidden" name="partn"  class="form-control" value="${pro.getPart_number()}" >
          <input type="submit" value="Voir" class="btn btn-success btn-lg pull-left">
          
          </form>
          
          </td>
          
          <td> 
          <form action="Graphe" method="get">
          <input type="hidden" name="partn"  class="form-control" value="${pro.getPart_number()}" >
          <input type="submit" value="Voir Graphe" class="btn btn-secondary btn-lg pull-left">
          </form>
          </td>
          
          
          
          <td><form action="Editprojet" method="post">
          <input type="hidden" name="nomp"  class="form-control" value="${pro.getNom_projet()}" >
          <input type="hidden" name="partname"  class="form-control" value="${pro.getPart_name()}" >
          <input type="hidden" name="partn"  class="form-control" value="${pro.getPart_number()}" >
          <input type="hidden" name="draw"  class="form-control" value="${pro.getDrawing()}" >
          <input type="hidden" name="datess"  class="form-control" value="${pro.getDate_soumission()}" >
          <input type="hidden" name="datede"  class="form-control" value="${pro.getDelai_projet()}" >
          <input type="hidden" name="etat"  class="form-control" value="${pro.getStatu_PPAP()}" >
          <input type="hidden" name="numcl"  class="form-control" value="${pro.getPart_n()}" >
          
          <input type="submit" value="Modifier" class="btn btn-danger btn-lg pull-left">
          
          </form>
          </td>
          
        </tr>
        
        
      </tbody>
       </c:forEach>
    </table>
    <a class="btn btn-info btn-lg" href="projet.jsp" role="button" >Ajouter Projet</a>
  </div>
  
  
  
  
      
</body>
</html>