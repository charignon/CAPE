<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap" %>
    <%
    	//On récupère la liste des cookies
    	Cookie[] cookies = request.getCookies();
    	HashMap map = new HashMap();
    	//S'il y a au moins un cookie, on stocke les clés-valeurs dans une Map
    	if(cookies != null){	    	
	    	for(Cookie cookie : cookies){
	    		map.put(cookie.getName(), cookie.getValue());
	    	}
    	}
    	
    	//Ainsi, si des données existent, on pourra préremplir les champs de notre formulaire
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

	  body{
background : lightblue;}
	  #form{
	  width : 260px;
	  height : 200px;
	  margin : 150px auto ;
	  background : white;
	  text-align:center;
	  -moz-border-radius : 10px;
	  -webkit-border-radius:10px;
	  padding : 20px;
	  font-family: "Trebuchet MS", Verdana, Geneva, Arial;
	  line-height:30px;
	  }
	  .field {
-moz-border-radius : 10px;


background : #F2F2F2;
padding : 5px;
margin:5px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion à l'application</title>
</head>
<body>
<form id ="form" name="session" method="POST" action="connexion.do" /> 
		
					<label>Login</label><br/>
					<input class="field" type="text" name="login" value="<%=((map.get("login") != null) ? map.get("login") : "") %>"/> <br/>
					<label>Mot de passe</label><br/>
					<input class="field" type="password" name="password"  value="<%=((map.get("login") != null) ? map.get("password") : "") %>"/><br/> 
						<label>Se souvenir de moi</label>
						<input type="checkbox" name="auto_connect"  value="Y" <%=(((map.get("login") != null) && (map.get("login") != null)) ? "checked" : "") %>/><br/> 
					<input type="submit" name="valider" />

</form>
</body>
</html>
