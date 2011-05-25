<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.awt.Color" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERREUR 404 : page non trouvée</title>
</head>
<body>

<%
	Color tab[] = {
					new Color(Color.lightGray.getRGB()),
					Color.gray,
					Color.darkGray,
					Color.black,
					Color.red,
					Color.pink,
					Color.orange,
					Color.yellow,
					Color.green,
					Color.magenta,
					Color.cyan,
					Color.blue
				}; 
	String titre = "ERREUR 404";
	String message = "La page demandée n'est pas disponible ! ";
	char tabTitre[] = titre.toCharArray();
	
	out.print("<h1>");
	
	for(int i = 0, j = 0; i < tabTitre.length; i++, j++){
		if(j == tab.length) j = 0;
		out.print("<span style=\"color:rgb(" + tab[j].getRed() + ", " + tab[j].getGreen() + ", " + tab[j].getBlue() + ")\">" + tabTitre[i] + "</span>");
	}
	
	out.print("</h1>");
	
	char tabMessage[] = message.toCharArray();
	
	out.print("<p>");
	
	for(int i = 0, j = 0; i < tabMessage.length; i++, j++){
		if(j == tab.length) j = 0;
		out.print("<span style=\"color:rgb(" + tab[j].getRed() + ", " + tab[j].getGreen() + ", " + tab[j].getBlue() + ")\">" + tabMessage[i] + "</span>");
	}
	
	out.print("</p>");

%>

</body>
</html>
