import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int ans = isPalin(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())) ? 1 : 0;
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    private static boolean isPalin(int s, int e){
        while(arr[s++] == arr[e--]){
            if(s>=e) return true;
        }

        return false;
    }
}
