import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 125;
    static int[][] cave = new int[MAX_N][MAX_N];
    static int N;
    static int problemCount = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            // 동굴 정보 입력
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra();

            // 결과 저장
            sb.append("Problem ").append(problemCount++).append(": ").append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        pq.offer(new Node(0, 0, cave[0][0]));
        dist[0][0] = cave[0][0];

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;

            if (current.x == N-1 && current.y == N-1) {
                return current.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newCost = current.cost + cave[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        return dist[N-1][N-1];
    }
}