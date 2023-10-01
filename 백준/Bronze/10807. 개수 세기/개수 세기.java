import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A[] = new int[201];
    	int N = sc.nextInt();
    	for(int i=0; i<N; i++) {
    		int index=sc.nextInt();
    		A[index+100]++;
    	}
    	System.out.println(A[sc.nextInt()+100]);
    }
}
