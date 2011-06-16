import java.sql.*;
import java.security.MessageDigest;

public class Test {
  public static void main(String[] args) throws Exception {
    Class.forName("org.sqlite.JDBC");
    Connection conn =
	DriverManager.getConnection("jdbc:sqlite:main_db.sqlite");
    Statement stat = conn.createStatement();
       /* stat.executeUpdate("drop table if exists people;");
    stat.executeUpdate("create table people (name, occupation);");
    PreparedStatement prep = conn.prepareStatement(
      "insert into people values (?, ?);");

    prep.setString(1, "Gandhi");
    prep.setString(2, "politics");
    prep.addBatch();
    prep.setString(1, "Turing");
    prep.setString(2, "computers");
    prep.addBatch(); 
    prep.setString(1, "Wittgenstein");
    prep.setString(2, "smartypants");
    prep.addBatch();

    conn.setAutoCommit(false);
    prep.executeBatch();
    conn.setAutoCommit(true);
    */

    //All the basics data to build a teacher entry into the database
    String login  = "bd";
    String password  = "bob";
    String nom    = "David";
    String prenom = "Bertrand";
    String statut = "Professeur de traitement du signal";
    MessageDigest md = MessageDigest.getInstance("SHA-1");
    String hash = new String (md.digest(password.getBytes()));
    
    PreparedStatement prep = conn.prepareStatement("insert into professeur(nom,prenom,statut,login,password) values (?, ?,?,?,?);");
    prep.setString(1,nom);
    prep.setString(2,prenom);
    prep.setString(3,statut);
    prep.setString(4,login);
    prep.setString(5,hash);
    prep.addBatch();
    conn.setAutoCommit(false);
    prep.executeBatch();
    conn.setAutoCommit(true);






    
    ResultSet rs = stat.executeQuery("select * from professeur;");
        
    while (rs.next()) {
      System.out.println("nom = " + rs.getString("nom"));
      System.out.println("prenom = " + rs.getString("prenom"));
    }
    rs.close();
    conn.close();
  }
}








