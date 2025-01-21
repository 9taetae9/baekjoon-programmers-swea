import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        arr[0][0] = 0;

        int minCnt = 10000;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                int nextCnt = cur[2] + 1;

                if(nextX == N-1 && nextY == M-1){
                    minCnt = Math.min(minCnt, nextCnt);
                    continue;
                }

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || arr[nextX][nextY] != 1){
                    continue;
                }

                queue.offer(new int[]{nextX,nextY,nextCnt});
                arr[nextX][nextY] = 0;
            }
        }

        System.out.println(minCnt);
    }
}
