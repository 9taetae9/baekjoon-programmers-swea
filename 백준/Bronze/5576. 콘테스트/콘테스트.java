import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] W = new int[10];
        int[] K = new int[10];
        for(int i=0; i<10; i++){
            W[i] = sc.nextInt();
        }
        for(int i=0; i<10; i++){
            K[i] = sc.nextInt();
        }

        Arrays.sort(W);
        Arrays.sort(K);

        int wsum = 0;
        int ksum = 0;
        for(int i=7; i<10; i++){
            wsum+=W[i];
            ksum+=K[i];
        }

        System.out.println(wsum+" "+ksum);
    }
}