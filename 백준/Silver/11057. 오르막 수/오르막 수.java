import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N == 1){
            System.out.println(10);
            return;
        }

        long[] dp = new long[10];
        Arrays.fill(dp,1);

        for(int i=2; i<=N; i++) {
            for (int j = 1; j <= 9; j++) {
                dp[j] = (dp[j - 1] + dp[j])%10007;
            }
        }

        long sum = 0;
        for(long e : dp){
            sum+=e%10007;
        }
        System.out.println(sum%10007);
    }
}