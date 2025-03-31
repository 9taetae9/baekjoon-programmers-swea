import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M;) {
                if(arr[i][j] == '-'){
                    while (j < M && arr[i][j] == '-') {
                        j++;
                    }
                    cnt++;
                }
                j++;
            }
        }

        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N;) {
                if(arr[i][j] == '|'){
                    while (i < N && arr[i][j] == '|') {
                        i++;
                    }
                    cnt++;
                }
                i++;
            }
        }

        System.out.println(cnt);
    }
}
