import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Point {
        int x, y, z;
        
        Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M];
        
        // 입력 받기
        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if(box[h][n][m] == 1) {
                        queue.offer(new Point(h, n, m));
                    }
                }
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            
            for(int i = 0; i < 6; i++) {
                int nz = current.z + dz[i];
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];
                
                if(nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if(box[nz][ny][nx] == 0) {
                        queue.offer(new Point(nz, ny, nx));
                        box[nz][ny][nx] = box[current.z][current.y][current.x] + 1;
                    }
                }
            }
        }
        
        int result = 0;
        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(box[h][n][m] == 0) return -1;
                    result = Math.max(result, box[h][n][m]);
                }
            }
        }
        
        return result - 1;
    }
}