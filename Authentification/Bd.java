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
	
	public boolean isProf(String login, String password) throws NoSuchAlgorithmException
	{
		System.out.println("Loading database driver");
	    try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    Connection conn = null;
		System.out.println("Connecting database");
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:/home/laurent/main_db.sqlite");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Preparing statement");
	    try {
			java.sql.Statement stat =  conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    
	    
	    PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement("select * from professeur where login=? AND password=?;");
			prep.setString(1,login);
			prep.setString(2,password );
			
			
			//prep.se(2, a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		try {
			 rs = prep.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
			while (rs.next()) {
				System.out.println("UTILISATEUR CORRECT !");
			      System.out.println("nom = " + rs.getString("nom"));
			      System.out.println("prenom = " + rs.getString("prenom"));
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	

}
