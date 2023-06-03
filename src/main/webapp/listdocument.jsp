<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>list des documents </title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

<%

Object part_number = request.getAttribute("part_number");
Object nomelement = request.getAttribute("name_element");

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
       
      <h1>List des éléments</h1>  
    </div>
   
  </div>


  <div class="container">
 
    <p>Les information des éléments :</p>            
    <table class="table table-bordered">
      <thead>
        <tr>
       <th>Nom de document</th>
      <th>Date</th>
      <th>Etat</th>
      <th>Remarque</th>
      <th>Fichier</th>
      <th>Nom</th>
      <th>Prenom</th>
      <th>Modifier</th>
      <th>Archive</th>
        </tr>
      </thead>
    
      
      
  
       <tbody>
       
     <c:forEach items="${Alldocument}" var="doc">  
        <tr>
          
       <td>${doc.getName_document()}</td>
      <td>${doc.getDated()}</td>
      <td>${doc.getEtat_d()}</td>
      <td>${doc.getRemarque()}</td>
      
         <td><input type="hidden" name="al1"  class="form-control" value="<%=nomelement%>" >
      <input type="hidden" name="al2"  class="form-control" value="<%=part_number %>" >
      <input type="hidden" name="al3"  class="form-control" value="${doc.getName_document()}" >
      <input type="hidden" name="al4"  class="form-control" value="${doc.getF()}" >
      <a href="download?al1=<%=nomelement %>&al2=<%=part_number %>&al3=${doc.getName_document()}">Download File 1</a>
      </td>
      <td>${doc.getNom()}</td>
      <td>${doc.getPrenom()}</td>
      <td><form action="Modifierdocument" method="post">
        <input type="hidden" name="al1"  class="form-control" value="<%=nomelement%>" >
      <input type="hidden" name="al2"  class="form-control" value="<%=part_number %>" >
      <input type="hidden" name="al3"  class="form-control" value="${doc.getName_document()}" >
      <input type="hidden" name="al4"  class="form-control" value="${doc.getF()}" >
      <input type="hidden" name="al5"  class="form-control" value="${doc.getDated()}" >
      <input type="hidden" name="al6"  class="form-control" value="${doc.getEtat_d()}" >
      <input type="hidden" name="al7"  class="form-control" value="${doc.getRemarque()}" >
      <input type="submit" value="Modifier Fichier" class="btn btn-link ">
      </form></td>
     
      <td><form action="RlistdocumentArchive" method="post">
        <input type="hidden" name="al1"  class="form-control" value="<%=nomelement%>" >
      <input type="hidden" name="al2"  class="form-control" value="<%=part_number %>" >
      <input type="hidden" name="al3"  class="form-control" value="${doc.getName_document()}" >
       <input type="hidden" name="al4"  class="form-control" value="${doc.getF()}" >
      <input type="submit" value="Archive fichier" class="btn btn-link ">
      </form></td>
        </tr>
      </tbody>
        </c:forEach>
    </table>
    
    <form action="Refdocument" method="post">
    <input type="hidden" name="partn"  class="form-control" value="<%=part_number%>" >
    <input value="<%= nomelement%>" type="hidden" name="nomelement" class="form-control" required>
     <input type="submit" value="Ajouter document" class="btn btn-info btn-lg pull-left">
    </form>
   
  </div>
  
  