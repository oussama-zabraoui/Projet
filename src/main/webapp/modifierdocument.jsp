<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>Document </title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

</head>


<%  if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}



%>


<body>

<%
Object part_number = request.getAttribute("part_number");
Object nomelement = request.getAttribute("name_element");
Object etat = request.getAttribute("etat");
Object remarque = request.getAttribute("remarque");
Object name_document = request.getAttribute("name_document");
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
    <h3 class="panel-title">Liste des document</h3>
  </div>
  <div class="panel-body">
  <form action="Rlistelement" method="get">
    <input value="<%= part_number %>" type="hidden" name="partn" >
    <input type="submit" value="Liste des document" class="btn btn-warning btn-lg">
</form> 
    
  </div>
</div>
</div>
</div>




<div class="container">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title"> Ajouter document </h3>
  </div>
  
  
  <div class="panel-body">
 

<%
		String msg = (String) session.getAttribute("msg");
		if (msg != null) {
		%>
		<h4 class="text-center text-success"><%=msg%></h4>
		<%
		session.removeAttribute("msg");
		}
		%>


  

 <form action="UpdatFile" method="post" enctype="multipart/form-data">
  <div class="container">
    <div class="row">
    <input value="<%= session.getAttribute("nom")%> " type="hidden" name="nom">
    <input value="<%= session.getAttribute("prenom")%> " type="hidden" name="prenom">
  <div class="col-xs-6 col-md-4"><label>Nom de projet : </label><label class="form-control"><%= nomelement%> </label><input value="<%= nomelement%>" type="hidden" name="nomelement" class="form-control" required></div>
   <div class="col-xs-6 col-md-4"><label>Part_N : </label><label class="form-control"><%= part_number %></label><input value="<%= part_number %>" type="hidden" name="partn"  class="form-control" required></div>
  <div class="col-xs-6 col-md-4"></div>
    </div>
  <div class="row">
  <div class="col-xs-6 col-md-4"><label>Nom de document : </label><label class="form-control"><%= name_document %></label><input value="<%=name_document %>" type="hidden" name="nomd" class="form-control" required></div>
     <div class="col-xs-6 col-md-4"><label>Statu d'element : </label>
          <select class="form-control" name="etat" id="etat"> <option>Approved</option> <option>Pending</option><option>Rejected</option><option>Hold</option><option>Ongoing</option>  </select>


          </div>
      <div class="col-xs-6 col-md-4"></div>
  </div>
 
  <div class="row">
          <div class="col-xs-6 col-md-4"><label>Remarque : </label>
          
         <input value="<%=remarque %>" type="text" name="remarque"  class="form-control" required>

          </div>
          <div class="col-xs-6 col-md-4"><label>fichier : </label><input type="file" id="file" name="file" class="form-control" multiple></div>
          <div class="col-xs-6 col-md-4"></div>
    </div>  
   </div>
  <br>
 
 
 
 
  
  <input type="submit" value="Modifier document" class="btn btn-primary btn-lg pull-left">
</form> 




  </div>
</div>
</div>


</body>
</html>