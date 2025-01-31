import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;// = new char[25][25];
    static boolean[][] visited;// = new boolean[25][25];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }

        int cnt = 0;
        List<Integer> ascend = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    ascend.add(getArea(i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(ascend); 
        for (int area : ascend) {
            System.out.println(area);
        }
    }

    private static int getArea(int i, int j){
        int area = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            area++;

            for (int d = 0; d < 4; d++) {
                int nextX = cur[0] + dx[d];
                int nextY = cur[1] + dy[d];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }

        return area;
    }
}
