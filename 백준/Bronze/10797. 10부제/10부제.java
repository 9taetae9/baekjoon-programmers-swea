import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int date = sc.nextInt();
    	int cnt=0;
    	for(int i=0; i<5; i++) {
    		if(date==sc.nextInt())cnt++;
    	}
    	System.out.print(cnt);
    }
}
