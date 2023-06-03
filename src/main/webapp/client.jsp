<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>Add Clients  </title>
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
      <a class="navbar-brand" href="projet.jsp" >PPAP</a>
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
  <div class="col-xs-6 col-md-4">
 

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Liste des clients</h3>
  </div>
  <div class="panel-body">
    <a class="btn btn-warning btn-lg" href="Rlistclient"  role="button" >Liste des clients
    
    </a>
  </div>
</div>
</div>
</div>




<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title"> Ajouter client   </h3>
  </div>
  
  
  <div class="panel-body">
 





  

 <form action="Rclients" method="post">
  <div class="container">
    <div class="row">
  <div class="col-xs-6 col-md-4"><label>Nom : </label><input type="text" name="nomcl"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"><label>Prenom : </label><input type="text" name="prenomcl"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"></div>
    </div>
  <div class="row">
      <div class="col-xs-6 col-md-4"><label>Email : </label><input type="email" name="emailcl"  class="form-control" required></div>
      <div class="col-xs-6 col-md-4"><label>Num_tele : </label><input type="tel" name="numtelcl"  class="form-control" required></div>
      <div class="col-xs-6 col-md-4"></div>
  </div>
  <div class="row">
          <div class="col-xs-6 col-md-4"><label>Part_n </label><input type="text"  name="partncl"class="form-control" required></div>
          <div class="col-xs-6 col-md-4"></div>
          <div class="col-xs-6 col-md-4"></div>
  </div>
  
   </div>
  <br>
 
 
 
 
  
  <input  type="submit" value="Ajouter client" class="btn btn-primary btn-lg pull-left">
</form> 




  </div>
</div>
</div>


</body>
</html>