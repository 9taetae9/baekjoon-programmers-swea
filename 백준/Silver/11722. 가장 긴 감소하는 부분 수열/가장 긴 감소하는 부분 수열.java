import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1); // 각원소 자체

        int maxLen = 1;

        for(int i=1; i < N; i++){
            for(int j=0; j < i; j++){
                if(sequence[i] < sequence[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }
}