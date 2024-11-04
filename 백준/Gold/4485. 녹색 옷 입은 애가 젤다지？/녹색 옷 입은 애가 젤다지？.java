import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map; //~125
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int prob = 0;


        StringBuilder sb = new StringBuilder();
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            prob++;

            map = new int[N][N];
            StringTokenizer stringTokenizer;
            for(int i=0; i<N; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            int minCost = dijkstra(0, 0);

            sb.append("Problem ").append(prob).append(": ").append(minCost).append("\n");
           
        }
        System.out.print(sb);
        
    }

    private static int dijkstra(int x, int y) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int[][] costs = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }

        queue.offer(new int[]{x, y, map[x][y]});
        costs[x][y] = map[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1], cost = current[2];

            if (cx == N - 1 && cy == N - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newCost = cost + map[nx][ny];
                    if (newCost < costs[nx][ny]) {
                        costs[nx][ny] = newCost;
                        queue.offer(new int[]{nx, ny, newCost});
                    }
                }
            }
        }
        return -1;
    }

}
