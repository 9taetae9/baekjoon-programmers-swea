import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static boolean[][] arr = new boolean[500][500];
    static boolean[][] visited = new boolean[500][500];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
        int cnt = 0; int maxSize = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j] || !arr[i][j]) continue;

                Queue<int[]> queue = new ArrayDeque<>();
                visited[i][j] = true;
                queue.offer(new int[]{i, j});

                int size = 1;
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nextX = cur[0] + dx[d];
                        int nextY = cur[1] + dy[d];
                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || visited[nextX][nextY] || !arr[nextX][nextY])
                            continue;

                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        size++;
                    }
                }
                cnt++;
                maxSize = Math.max(maxSize, size);
            }
        }

        System.out.println(cnt);
        System.out.println(maxSize);
    }
}
