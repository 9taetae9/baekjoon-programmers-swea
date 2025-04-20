import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int cntW = 0;
        int cntB = 0;
        boolean W = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cnt;
                if(arr[i][j] == 'W'){
                    W = true;
                    cnt = bfs(i, j, 'W');
                }else if(arr[i][j] == 'B'){
                    W = false;
                    cnt = bfs(i,j, 'B');
                }else{
                    continue;
                }

                if (W) {
                    cntW += cnt * cnt;
                } else {
                    cntB += cnt * cnt;
                }
            }
        }

        System.out.println(cntW + " " + cntB);



    }

    private static int bfs(int x, int y, char target) {
        Deque<int[]> queue = new ArrayDeque<>();
        arr[x][y] = 'v';
        queue.add(new int[]{x,y});

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (arr[nx][ny] == target) {
                    arr[nx][ny] = 'v';
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }

}
