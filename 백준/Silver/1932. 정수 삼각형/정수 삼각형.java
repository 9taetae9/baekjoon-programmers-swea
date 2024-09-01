import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for(int i=0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + arr[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + arr[i + 1][j + 1]);
            }
        }
        int max = 0;
        for(int i=0; i < n; i++){
            max = Math.max(dp[n-1][i], max);
        }

        System.out.println(max);
    }


}