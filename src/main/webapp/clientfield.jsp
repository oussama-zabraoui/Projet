<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>client field</title>
<script src="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://common.olemiss.edu/_js/sweet-alert/sweet-alert.css">
</head>
<body>
<script>
swal({
  title: "Error!",
  text: "client n'est pas ajouter!",
  type: "error",
  confirmButtonText: "ok"
});
</script>

<jsp:include page="client.jsp"></jsp:include>
</body>
</html>