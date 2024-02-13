import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr= new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j]>0 && arr[i][j]>0){
                    int jump = arr[i][j];
                    if(i+jump < n)
                        dp[i+jump][j] += dp[i][j];
                    if(j+jump < n)
                        dp[i][j+jump] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}