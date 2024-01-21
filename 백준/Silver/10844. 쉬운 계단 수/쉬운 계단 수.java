import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N==1){
            System.out.println(9);
            return;
        }

        long[][] dp = new long[N+1][12];
        for(int i=2; i<11; i++){
            dp[1][i] = 1;
        }


        for(int i=2; i<=N; i++){
            for(int j=1; j<11; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
            }
        }

        long sum=0;
        for(int i=1; i<11; i++){
            sum+=dp[N][i]%1000000000;
        }

        System.out.println(sum%1000000000);
    }
}