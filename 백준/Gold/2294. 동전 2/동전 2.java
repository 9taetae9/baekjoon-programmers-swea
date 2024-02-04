import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int n, target;
    Set<Integer> set;

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(br.readLine()));
        }


        int[] dp = new int[target+1];

        final int INF = target + 1;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int e : set) {
            for (int j = 1; j < dp.length; j++) {
                if(j-e >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - e] + 1);
                }
            }
        }

        System.out.println(dp[target] != INF ? dp[target] : -1);
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }


}