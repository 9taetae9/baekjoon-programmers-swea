import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if(n <= 2) {
            if (n == 1) {
                System.out.println(wine[1]);
            }else {
                System.out.println(wine[1] + wine[2]);
            }
            return ;
        }

        dp[1] = wine[1];
        dp[2] = dp[1] + wine[2];

        for(int i=3; i <= n; i++){
            dp[i] = Math.max(wine[i]+wine[i-1]+dp[i-3], wine[i]+dp[i-2]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        
        System.out.println(dp[n]);
    }
}