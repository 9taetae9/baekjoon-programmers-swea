import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int N;
    static int target;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0);
        if(target == 0) cnt--;
        System.out.println(cnt);

    }

    private static void backtrack(int start, int sum) {
        if(start == N){
            if(sum == target) cnt++;
            return;
        }
        backtrack(start+1, sum + arr[start]);
        backtrack(start+1, sum);

    }

}
