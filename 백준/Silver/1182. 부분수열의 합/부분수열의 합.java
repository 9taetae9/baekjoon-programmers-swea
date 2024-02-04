import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int n, target;
    int[] arr;

    static int cnt;
    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findNumTargetSubsequence(0, 0, 0);
        System.out.println(cnt);
    }

    void findNumTargetSubsequence(int idx, int sum, int element) {
        if(idx == arr.length){
            if(sum == target && element > 0){
                cnt++;
            }
            return;
        }
        findNumTargetSubsequence(idx+1, sum+arr[idx], element+1);
        findNumTargetSubsequence(idx+1, sum, element);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }


}