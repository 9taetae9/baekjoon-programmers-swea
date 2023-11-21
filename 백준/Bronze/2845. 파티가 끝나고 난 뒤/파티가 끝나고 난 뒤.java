import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a1 = sc.nextInt();
    	int a2 = sc.nextInt();
    	
    	for(int i=0; i<5; i++) {
    		int a3 = sc.nextInt();
    		System.out.print(a3-a1*a2+" ");
    	}
    }
}
