import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] isUsed = new boolean[9];
//    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //1~N까지의 수열
        M = Integer.parseInt(st.nextToken());  //고를 개수
        arr = new int[M];
        backtrack(0);
//        System.out.println(cnt+"가지");
    }

    private static void backtrack(int n) {
        if (n == M) {
//            cnt++;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                arr[n] = i;
                isUsed[i] = true;
                backtrack(n + 1);
                isUsed[i] = false;
            }
        }

    }
}
