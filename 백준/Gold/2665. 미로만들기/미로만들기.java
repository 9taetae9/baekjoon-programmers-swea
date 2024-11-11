import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static char[][] maze;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        maze = new char[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            maze[i] = line.toCharArray();
        }

        System.out.println(solution());


    }

    static class Point implements Comparable<Point>{
        int x, y;
        int change;

        Point (int x, int y, int change){
            this.x = x;
            this.y = y;
            this.change = change;
        }

        @Override
        public int compareTo(Point other){//change 작은 것 우선
            return Integer.compare(this.change, other.change);
        }
    }

    private static int solution() {
        visited = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(0,0,0));

        while(!q.isEmpty()){
            Point current = q.poll();
            int x = current.x;
            int y = current.y;

            if(x== n-1 && y == n-1){
                return current.change;
            }

            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX < 0 || nextX > n-1 || nextY < 0 || nextY > n-1) continue;

                int change = current.change + (maze[nextX][nextY] == '1' ? 0 : 1);

                if(change < visited[nextX][nextY]){
                    visited[nextX][nextY] = change;
                    q.offer(new Point(nextX, nextY, change));
                }
            }
        }

        return -1;
    }
}
