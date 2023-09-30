import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<T; i++) {
        	String text=sc.nextLine();
        	String answer=
        			text.substring(0,1)+
        			text.substring(text.length()-1);
        	System.out.println(answer);
        }

        sc.close();
	}
}
