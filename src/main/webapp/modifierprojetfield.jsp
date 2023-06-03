<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>projet n'est pas ajouter</title>
<script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
</head>
<body>
<script type="text/javascript">

swal({
	  title: "Error!",
	  text: "projet n'est pas update!",
	  type: "error",
	  confirmButtonText: "ok"
	});

</script>
<jsp:include page="modifierprojet.jsp"></jsp:include>
</body>
</html>