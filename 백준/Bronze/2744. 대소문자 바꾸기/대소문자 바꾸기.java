import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
    	String s= sc.next();
    	
    	for(int i=0; i<s.length(); i++) {
    		changer(s.charAt(i));
    	}
    	
    	sc.close();
    }
    
    static void changer(char charAt) {
    	if(charAt<=90) System.out.print((char)(charAt+97-65)); 
    	else System.out.print((char)(charAt-(97-65)));
	}
    
}
