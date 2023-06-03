<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>Element </title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<%  if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}
%>



<body>

<%
Object part_number = request.getAttribute("part_number");


%>



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
ArrayList<Integer> liste =req.getEquipe();
System.out.println(liste);
request.setAttribute("liste", liste);

%>


<div class="container">
  <div class="col-xs-6 col-md-4">
 

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Liste des elements</h3>
  </div>
  <div class="panel-body">
  <form action="Rlistelement" method="get">
    <input value="<%= part_number %>" type="hidden" name="partn" >
    <input type="submit" value="Liste des elements" class="btn btn-warning btn-lg">
</form> 
    
  </div>
</div>
</div>
</div>




<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title"> Ajouter element  </h3>
  </div>
  
  
  <div class="panel-body">
 





  

 <form action="Relement" method="post">
  <div class="container">
    <div class="row">
  <div class="col-xs-6 col-md-4"><label>Nom de projet : </label><select name="nomelement" id="nomelement" class="form-control" >
    <option value="">--Please choisir  une option--</option>
    <option>1-Design Record / Drawing</option><option >2-ECN</option><option >3-Customer Engineering approval</option><option >4-Design FMEA
</option><option >5-Process Flow Chart</option><option >6-Process FMEA
</option><option >6-Process FMEA</option><option >7-Coontrol Plan </option>
    <option >8-Measurment Systems analysis studies </option><option >9-dimensional results</option><option >10-Records of Material</option><option>11-Initial Process capabilty
</option><option >12-Qualified Laboratory Documentation</option><option >13-Appearance Approval Report
</option><option >14-Sample Product</option><option >15-Master Sample</option><option >16-Checking Aids / Gauges</option><option >17-Customer Specific Requirements</option><option >18-Part Submission Warrant(PSW/PPA)

</select></div>
   <div class="col-xs-6 col-md-4"><label>Part_N : </label><label class="form-control"><%= part_number %></label><input value="<%= part_number %>" type="hidden" name="partn"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"></div>
    </div>
  <div class="row">
  <div class="col-xs-6 col-md-4"><label>date_debut : </label><input type="date" id="start" name="dated" value="2023-01-01" class="form-control" required></div>
      <div class="col-xs-6 col-md-4"><label>date_fin : </label><input type="date" id="start" name="datef" value="2023-01-01" class="form-control" required></div>
      <div class="col-xs-6 col-md-4"></div>
  </div>
 
  <div class="row">
          <div class="col-xs-6 col-md-4"><label>Statu d'element : </label>
          <select class="form-control" name="etat" id="etat"> <option>Approved</option> <option>Pending</option><option>Rejected</option><option>Hold</option><option>Ongoing</option>  </select>


          </div>
          <div class="col-xs-6 col-md-4"><label>Matricule equipe : </label>
          <select name="matree" class="form-control" required>
          <c:forEach  items="${liste}" var="equi"> <option>${equi}</option> </c:forEach> </select>
          </div>
          <div class="col-xs-6 col-md-4"></div>
    </div>  
   </div>
  <br>
 
 
 
 
  
  <input type="submit" value="Ajouter element" class="btn btn-primary btn-lg pull-left">
</form> 




  </div>
</div>
</div>


</body>
</html>