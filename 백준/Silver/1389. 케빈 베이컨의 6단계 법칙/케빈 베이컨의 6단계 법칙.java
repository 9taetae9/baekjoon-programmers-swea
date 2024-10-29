import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] bacon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 유저 수  (2 ≤ N ≤ 100)
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수 (1 ≤ M ≤ 5,000)


        bacon = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(bacon[i], 5000);
            bacon[i][i] = 0;
        }


        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u1 = Integer.parseInt(st.nextToken());
            int u2 = Integer.parseInt(st.nextToken());
            bacon[u1][u2] = bacon[u2][u1] = 1;
        }

        for(int k=1; k <=N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (bacon[i][j] > bacon[i][k] + bacon[k][j]) {
                        bacon[i][j] = bacon[i][k] + bacon[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int user = 0;
        for(int i = 1; i <= N; i++){
            int sum = 0;
            for(int j = 1; j <= N; j++){
                sum += bacon[i][j];
            }
            if(min > sum) {
                min = sum;
                user = i;
            }
        }

        System.out.println(user);

    }


}