import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr = new int[8];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        backtrack(1, 0);
        System.out.println(sb);
    }

    private static void backtrack(int prev, int step) {
        if (step == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]);
                if(i != M) sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = prev; i <= N; i++) {
            arr[step] = i;
            backtrack(i, step+1);
        }
    }
}
