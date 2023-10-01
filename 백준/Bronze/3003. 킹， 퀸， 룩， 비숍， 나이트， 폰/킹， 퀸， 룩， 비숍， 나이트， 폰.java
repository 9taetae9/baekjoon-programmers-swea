import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] chess= {1,1,2,2,2,8};
        for(int i=0; i<6; i++) {
        	System.out.print(chess[i]-sc.nextInt()+" ");
        }
        sc.close();
    }
}
