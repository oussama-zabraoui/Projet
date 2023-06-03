<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>modifier element</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<%  if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}



%>



<body>

<%
   
Object nomelement =  request.getAttribute("name_element"); 
Object partn = request.getAttribute("part_number");
Object dated = request.getAttribute("date_debut"); 
Object datef = request.getAttribute("date_fin");
Object etat = request.getAttribute("statu_element");
Object mateq = request.getAttribute("id_equipe");
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
    <h3 class="panel-title">Liste des elements</h3>
  </div>
  <div class="panel-body">
  <form action="Rlistelement" method="get">
    <input value="<%= partn %>" type="hidden" name="partn" >
    <input type="submit" value="Liste des elements" class="btn btn-warning btn-lg">
</form> 
    
  </div>
</div>
</div>
</div>




<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title"> Modifier element  </h3>
  </div>
  
  
  <div class="panel-body">
 





  

 <form action="Modifierelement" method="post">
  <div class="container">
 <div class="row">
  <div class="col-xs-6 col-md-4"><label>Nom de projet : </label><label class="form-control"><%= nomelement%> </label><input value="<%= nomelement%> " type="hidden" name="nomelement" class="form-control" required></div>
 
   <div class="col-xs-6 col-md-4"><label>Part_N : </label><label class="form-control"><%= partn %></label><input value="<%= partn %>" type="hidden" name="partn"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"></div>
    </div>
  <div class="row">
  <div class="col-xs-6 col-md-4"><label>date_debut : </label><input value="<%=dated %>" type="date" id="start" name="dated" value="2023-01-01" class="form-control" required></div>
      <div class="col-xs-6 col-md-4"><label>date_fin : </label><input value="<%=datef %>" type="date" id="start" name="datef" value="2023-01-01" class="form-control" required></div>
      <div class="col-xs-6 col-md-4"></div>
  </div>
 
  <div class="row">
          <div class="col-xs-6 col-md-4"><label>Statu d'element : </label>
          <select class="form-control" name="etat" id="etat"> <option>Approved</option> <option>Pending</option><option>Rejected</option><option>Hold</option><option>Ongoing</option>  </select>


          </div>
          <div class="col-xs-6 col-md-4"><label>Matricule equipe : </label><input value="<%=mateq %>"  type="text" name="mateq"  class="form-control" required></div>
          <div class="col-xs-6 col-md-4"></div>
    </div>  
   </div>
  <br>
 
 
 
 
  
  <input type="submit" value="Mise à jour de l'élément" class="btn btn-primary btn-lg pull-left">
</form> 




  </div>
</div>
</div>


</body>
</html>
  






