import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //회원수 N <= 50


        friend = new int[N + 1][N + 1];

        for(int i=1; i<=N; i++){
            Arrays.fill(friend[i], 49);
            friend[i][i] = 0;
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u1 = Integer.parseInt(st.nextToken());
            int u2 = Integer.parseInt(st.nextToken());

            if (u1 == -1 && u2 == -1) break;

            friend[u1][u2] = friend[u2][u1] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (friend[i][j] > friend[i][k] + friend[k][j] ) {
                        friend[i][j] = friend[i][k] + friend[k][j];
                    }
                }
            }
        }

        int[] userScore = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                userScore[i] = Math.max(friend[i][j], userScore[i]);
            }
        }

        int min = 49;
        for (int i = 1; i <= N; i++) {
            min = Math.min(userScore[i], min);
        }

        System.out.print(min + " ");

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (userScore[i] == min) cnt++;
        }

        System.out.println(cnt);
        for (int i = 1; i <= N; i++) {
            if (min == userScore[i]) System.out.print(i + " ");
        }
    }
}