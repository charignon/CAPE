<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page 1</title>
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
						background-color:white;
						color:#404AA4;
						font-weight:bold;
						text-align:center"
					>Page 1
				</td>
				<td 
					style="
						background-color:#404AA4;
						color:white;
						font-weight:bold;
						text-align:center;
						border:1px solid black"
					>
					<a href="page2.jsp" style="color:white;text-decoration:none">Page 2</a>
				</td>
				<td 
					style="
						background-color:#404AA4;
						color:white;
						font-weight:bold;
						text-align:center;
						border:1px solid black"
					>
					<a href="page3.jsp"  style="color:white;text-decoration:none">Page 3</a>
				</td>
				<td 
					style="
						background-color:#404AA4;
						color:white;
						font-weight:bold;
						text-align:center;
						border:1px solid black"
					>
					<a href="disconnect.do" style="color:white;text-decoration:none">Se déconnecter</a>
				</td>
			</tr>
		</thead>
		
		<tbody
			style="
				background-color:#AAB0DF;
				height:150px;
				text-align:center;
				border:1px solid black
				"
			>
			<tr>
				<td colspan=4>
				<%= request.getAttribute("nom") %>
				Vous êtes sur la page 1.</td>
			</tr>
		</tbody>
	</table>

</body>
</html>
