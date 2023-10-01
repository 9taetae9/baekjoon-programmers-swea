import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println(factorial(num)); 
		sc.close();
	}
	
	static int factorial(int n) {
		if(n<=1) return 1;
		else return n*factorial(n-1);
	}
}
