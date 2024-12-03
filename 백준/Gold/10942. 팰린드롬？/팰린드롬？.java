import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
    static int[] arr = new int[2001];
    static boolean[][] dp = new boolean[2001][2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initializeDp(N);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }

    private static void initializeDp(int N){
        //길이 1
        for(int i=1; i<=N; i++){
            dp[i][i] = true;
        }

        //길이 2
        for(int i=1; i<N; i++){
            if(arr[i] == arr[i+1]) {
                dp[i][i + 1] = true;
            }
        }

        //길이 3 이상
        for(int len = 3; len <= N; len++){
            for(int start = 1; start <= N-len+1; start++){
                int end = start+len-1;
                if(arr[start] == arr[end] && dp[start+1][end-1]){
                    dp[start][end] = true;
                }
            }
        }
    }
}