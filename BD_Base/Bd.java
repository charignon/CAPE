import java.security.MessageDigest;
public class Bd {

    public Bd()
    {
    }
    
    
    public String returnHash(String f) throws Exception{
	MessageDigest md = MessageDigest.getInstance("SHA-1");
	return new String(md.digest(f.getBytes()));
	
	
    }
    

}
