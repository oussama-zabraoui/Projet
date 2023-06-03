<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>Graphe de l'état des éléments </title>
 <link href="css/bootstrap.min.css" rel="stylesheet">

<%

Object part_number = request.getAttribute("part_number");

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
<p style="font-weight: 900;text-align: center ;color:red">1 : Approved | 2 : Hold |  3 : Rejected |  4 : Pending |  5 : Ongoing </p>
 <canvas id="myChart" style="width:100%;max-width:1200px"></canvas>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script>
// Initialize xValues and yValues arrays
var xValues = [];
var yValues = [];

// Populate xValues array using JSTL forEach loop //tester  sat doz watsap n9oulik fin blan
<c:forEach items="${Allname}" var="pro">
  <c:set var="currentValue" value="${pro}" />
  xValues.push("${currentValue}");
</c:forEach>
<c:forEach items="${Alletat}" var="pr">
<c:if test="${pr == 'Approved'}">
yValues.push(1);

</c:if>
<c:if test="${pr == 'Hold'}">
yValues.push(2);

</c:if>
<c:if test="${pr == 'Rejected'}">
yValues.push(3);

</c:if>
<c:if test="${pr == 'Pending'}">
yValues.push(4);

</c:if>
<c:if test="${pr == 'Ongoing'}">
yValues.push(5);

</c:if>
</c:forEach>
// Define barColors array
var barColors = ["red","green","blue","orange","brown","pink","gray","black","purple","gray","red","silver","yellow","blue","green","pink","brown","orange"];

// Create new Chart object
new Chart("myChart", {
  type: "bar",
  //scaleLabel:true,
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues
    }]
  },
  options: {
	   legend: {display: false},
	    maintainAspectRatio: false,  // Set to false to adjust width and height
	    title: {
	    	
	      display: true,
	      text: "Graphe de l'état des éléments"
	    },
	    scales: {
	      xAxes: [{
	        ticks: {
	          autoSkip: false  // Prevent labels from being skipped
	        }
	      }]
	    }
	  }
});
</script>
<div>

</div>
  
</body>
</html>