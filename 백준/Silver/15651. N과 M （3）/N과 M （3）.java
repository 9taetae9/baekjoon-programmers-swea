import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr = new int[8];
    static char[] buffer;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int set = 1;
        for (int i = 0; i < M; i++) {
            set *= N;
        }
        buffer = new char[M*2*set];

        backtrack(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(buffer);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtrack(int step) {
        if (step == M) {
            for (int i = 0; i < M; i++) {
                buffer[idx++] = (char)(arr[i] + '0');
                if( i<M-1){
                    buffer[idx++] = ' ';
                }
            }
            buffer[idx++] = '\n';
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[step] = i;
            backtrack(step+1);
        }
    }
}
