<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>Modifier Responsable</title>
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
  <div class="col-xs-6 col-md-4">
 

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Liste des Responsable</h3>
  </div>
  <div class="panel-body">
    <a class="btn btn-warning btn-lg" href="Rlistresp" role="button">Liste des Responsable
    
    </a>
  </div>
</div>
</div>
</div>




<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title"> Modifier Responsable    </h3>
  </div>
  
  
  <div class="panel-body">
 
<%
Object nomr =  request.getAttribute("nomr"); 
Object matr = request.getAttribute("matr");



%>




  

 <form action="Modifierresponsable" method="post">
  <div class="container">
    <div class="row">
  <div class="col-xs-6 col-md-4"><label>Nom de Responsable : </label><input value="<%=nomr %>" type="text" name="nomr"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"><label>Matricule de Responsable : </label><label class="form-control"><%=matr %></label><input value="<%=matr %>" type="hidden" name="matr"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"></div>
    </div>
 
   </div>
  <br>
 
 
 
 
  
  <input type="submit" value="Modifier responsable" class="btn btn-primary btn-lg pull-left">
</form> 




  </div>
</div>
</div>


</body>
</html>