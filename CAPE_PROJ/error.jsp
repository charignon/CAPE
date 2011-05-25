<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.awt.Color" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erreur de connexion</title>
</head>
<body>

	<table 
		style="
			margin:auto; 
			margin-top:50px;
			border-collapse:collapse;
			width:350px;
			text-align:right">
		
		<thead>
			<tr>
				<td 
					style="
						background-color:#404AA4;
						color:white;
						font-weight:bold;
						text-align:center"
					>Erreur lors de la connexion !
				</td>
			</tr>
		</tr>
		</thead>
		
		<tbody
			style="
				background-color:#AAB0DF;
				border-radius-bottom-left:5px;
				border-radius-bottom-right:5px;"
			>
			<tr>
				<td style="text-align:left;padding-left:20px">
					Des paramètres manquent afin de pouvoir vous connecter. Veuillez réessayer en cliquant sur <a href="connexion.jsp">ce lien</a>.
				</td>
			</tr>
		</tbody>
	</table>	

</body>
</html>
