


public class main{

public static void main (String argv[])
{
    Bd bd = new Bd();
    System.out.println("Bd créé à :"+bd);
    try { 
	System.out.println(bd.returnHash(argv[0]));}
    catch (Exception e){
	System.out.println("bob");}
    return;
}}
