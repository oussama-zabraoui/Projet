<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>Add Users</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<%  if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}



%>
<%
Object nom = request.getAttribute("nom");
Object prenom = request.getAttribute("prenom");
Object email = request.getAttribute("email");
Object mot_de_passe = request.getAttribute("mot_de_passer");
Object role = request.getAttribute("role");



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
  <div class="col-xs-6 col-md-4">
 

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Liste des utilisateurs</h3>
  </div>
  <div class="panel-body">
  
    <a class="btn btn-warning btn-lg" href="Rlistutilisateurs" role="button">Liste des utilisateurs
    
    </a>
  </div>
</div>
</div>
</div>




<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Modifier utilisateur</h3>
  </div>
  
  
  <div class="panel-body">
 





  

 <form action="UserAjouter" method="post">
  <div class="container">
    <div class="row">
  <div class="col-xs-6 col-md-4"><label>Nom : </label><input type="text" name="nom"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"><label>Prenom : </label><input  type="text" name="prenom"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"></div>
    </div>
  <div class="row">
      <div class="col-xs-6 col-md-4"><label>Email : </label><input  type="email" name="email"  class="form-control" required></div>
      <div class="col-xs-6 col-md-4"><label>Mot de passe : </label><input  type="text" name="mot_de_passe"  class="form-control" required></div>
      <div class="col-xs-6 col-md-4"></div>
  </div>
  <div class="row">
          <div class="col-xs-6 col-md-4"><label>Role : </label><input type="text" name="role"  class="form-control" required></div>
          <div class="col-xs-6 col-md-4"><label></div>
          <div class="col-xs-6 col-md-4"></div>
  </div>
   
   </div>
  <br>
 
 
 
 
  
  <input type="submit" value="Ajouter utilisateur" class="btn btn-primary btn-lg pull-left">
</form> 




  </div>
</div>
</div>


</body>
</html>