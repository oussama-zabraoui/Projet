<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Graphe de l'état des éléments</title>
</head>
<body>
<canvas id="myChart" style="width:100%;max-width:1200px"></canvas>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script>
// Initialize xValues and yValues arrays
var xValues = [];
var yValues = [0];

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
var barColors = ["red", "green","blue","orange","brown","pink","red", "green","blue","orange","brown","pink","red", "green","blue","orange","brown","pink"];

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
1 : Approved / 2 : Hold /  3 : Rejected /  4 : Pending /  5 : Ongoing 
</div>
</body>
</html>