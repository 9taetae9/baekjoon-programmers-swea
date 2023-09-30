import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n=T/4;
        for(int i=0; i<n; i++) {
        	System.out.print("long ");
        }
        System.out.print("int");

        sc.close();
	}
}
