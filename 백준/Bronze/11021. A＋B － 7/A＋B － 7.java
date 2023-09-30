import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int i=1; i<=T; i++) {
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		System.out.println("Case #"+i+": "+(x+y));
		}
		
		sc.close();
	}
}
