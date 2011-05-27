package com.model;
import java.beans.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bd {

	
	public String returnHash(String f) throws Exception{
				
	    MessageDigest md = MessageDigest.getInstance("SHA-1");
	    return new String(md.digest(f.getBytes()));
		
	}
	
	public String isProf(String login, String password) throws NoSuchAlgorithmException
	{
		System.out.println("Loading database driver");
	    try {Class.forName("org.sqlite.JDBC");} 
	    catch (ClassNotFoundException e) {e.printStackTrace();}
		
	    Connection conn = null;
	    PreparedStatement prep = null;
	    ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:/home/laurent/main_db.sqlite");
			java.sql.Statement stat =  conn.createStatement();
			prep = conn.prepareStatement("select * from professeur where login=? AND password=?;");
			prep.setString(1,login);
			prep.setString(2,password );
			rs = prep.executeQuery();
			while (rs.next()) {
				System.out.println("UTILISATEUR CORRECT !");
			      System.out.println("nom = " + rs.getString("nom"));
			      System.out.println("prenom = " + rs.getString("prenom"));
			      String nom = rs.getString("nom");
			      rs.close();
					conn.close();   
			      return nom;
			    }
			System.out.println("UTILISATEUR INCORRECT !");
			rs.close();
			conn.close();
		}
		
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "false";
	}
	
	
	

}
