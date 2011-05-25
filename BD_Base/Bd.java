import java.security.MessageDigest;
public class Bd {

    public Bd()
    {
    }
    
    
    public String returnHash(String f) throws Exception{
	System.out.println("Return Hash entrée");
	MessageDigest md = MessageDigest.getInstance("SHA-1");
	System.out.println("Return Hash sortie");
	return new String(md.digest(f.getBytes()));
	
	
    }
    

}
