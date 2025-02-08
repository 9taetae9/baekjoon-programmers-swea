import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int blue = 0;
    static int white = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void partition(int x, int y, int n) {
        if (colorCheck(x, y, n)) {
            if(arr[x][y] == 0) white++;
            else blue++;
            return;
        }

        int size = n/2;

        partition(x, y, size);
        partition(x+size, y, size);
        partition(x, y+size, size);
        partition(x+size, y+size, size);
    }

    private static boolean colorCheck(int x, int y, int n) {
        int t = arr[x][y];
        for (int i = x; i < x+n; i++) {
            for(int j=y; j < y+n; j++){
                if(t != arr[i][j]) return false;
            }
        }
        return true;
    }
}