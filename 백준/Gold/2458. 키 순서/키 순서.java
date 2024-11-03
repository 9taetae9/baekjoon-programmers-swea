import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] H;
    static boolean[] visited;

    public static void main(final String[] args) throws NumberFormatException, IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            final int u1 = Integer.parseInt(st.nextToken());
            final int u2 = Integer.parseInt(st.nextToken());
            H[u1-1][u2-1] = 1;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            dfs(i);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += H[i][j] + H[j][i];
            }
            if (sum == N - 1)
                answer++;
        }

        System.out.println(answer);
    }

    public static void dfs(final int s) {
        if (visited[s])
            return;

        for (int i = 0; i < N; i++) {
            if (H[s][i]==1) {
                dfs(i);
                for (int j = 0; j < N; j++) {
                    H[s][j] = H[s][j] | H[i][j];  //비트 연산으로 누적 경로(키 관계) 갱신
                }
            }
        }
        visited[s] = true;
    }
}