<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/index.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
 <section>
        <div class="form-box">
            <div class="form-value">
                <form action="login" method="post">
                    <div class="register">
                        <img src="css/polydesign.jpg" alt="polydesign" width="350px" height="120px">
                    </div>
                    
                    <h2>Login</h2>
                    <div class="inputbox">
                        <ion-icon name="mail-outline"></ion-icon>
                        <input name="email" type="email" required>
                        <label for="">Email</label>
                    </div>
                    <div class="inputbox">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input name="password" type="password" required>
                        <label for="">Mot de passe</label>
                    </div>
                    <div class="forget">
                       <% if(session.getAttribute("errmsg")!=null){
                    	String msg=(String)session.getAttribute("errmsg");
                    	%>
                    	<font color="red" ><%=msg %></font>
                    <% }%>
                    </div>
                    <input type="submit" class="button">
              
                    <div class="register">
                   
                        
                    </div>
                </form>
            </div>
        </div>
    </section>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>