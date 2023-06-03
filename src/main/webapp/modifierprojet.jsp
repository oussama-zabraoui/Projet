<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>modifier projet</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<%  if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}



%>


<body>

<%
   
Object nom_projet =  request.getAttribute("nom_projet"); 
Object part_number = request.getAttribute("part_number");
Object part_name = request.getAttribute("part_name"); 
Object drawing = request.getAttribute("drawing");
Object date_soumission = request.getAttribute("date_soumission");
Object delai_projet = request.getAttribute("delai_projet");
Object statu_PPAP = request.getAttribute("statu_PPAP");
Object part_n = request.getAttribute("part_n");
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



<div class="container">
  <div class="col-xs-6 col-md-4">
 

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Liste des projets</h3>
  </div>
  <div class="panel-body">
    <a class="btn btn-warning btn-lg" href="listprojet.jsp" role="button">Liste des projets
    
    </a>
  </div>
</div>
</div>
</div>




<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title"> Ajouter projet   </h3>
  </div>
  
  
  <div class="panel-body">
 





  

 <form action="Modifierprojet" method="post">
  <div class="container">
    <div class="row">
  <div class="col-xs-6 col-md-4"><label>Nom de projet : </label><input type="text" name="nomp"  class="form-control" value="<%= nom_projet %>" required></div>
  <div class="col-xs-6 col-md-4"><label>Part_N : </label><label class="form-control"><%= part_number %></label><input value="<%= part_number %>" type="hidden" name="partn"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"></div>
    </div>
  <div class="row">
      <div class="col-xs-6 col-md-4"><label>Part_Name : </label><input value="<%= part_name %>" type="text" name="partname"  class="form-control" required></div>
      <div class="col-xs-6 col-md-4"><label>drawing : </label><input value="<%= drawing %>" type="text" name="draw"  class="form-control" required></div>
      <div class="col-xs-6 col-md-4"></div>
  </div>
  <div class="row">
          <div class="col-xs-6 col-md-4"><label>Date de soumission : </label><input value="<%= date_soumission%>" type="date" id="start" name="datess" value="2023-01-01" class="form-control" required></div>
          <div class="col-xs-6 col-md-4"><label>Delai : </label><input value="<%= delai_projet %>" type="date" id="play" name="datede" value="2023-01-01" class="form-control" required></div>
          <div class="col-xs-6 col-md-4"></div>
  </div>
  <div class="row">
          <div class="col-xs-6 col-md-4"><label>Statu de PPAP : </label><select class="form-control" name="etat" id="etat"  value="<%= statu_PPAP %>"> <option>Open</option> <option>Close</option>  </select>
            <datalist id="etat"> <option>Open</option> <option>Close</option>  </datalist>


          </div>
          <div class="col-xs-6 col-md-4"><label>Numero de Client : </label><label class="form-control"><%= part_n %></label><input value="<%= part_n %>" type="hidden" name="numcl"  class="form-control" required></div>
          <div class="col-xs-6 col-md-4"></div>
    </div>  
   </div>
  <br>
 
 
 
 
  
  <input type="submit" value="Modifier projet" class="btn btn-primary btn-lg pull-left">
</form> 




  </div>
</div>
</div>


</body>
</html>