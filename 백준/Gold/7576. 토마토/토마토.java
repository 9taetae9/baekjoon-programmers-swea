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

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        int[][] arr = new int[N][M];
        boolean isNotRipe = false;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) {
                    queue.offer(new int[]{i,j, 0});
                }else if(n==0) isNotRipe = true;
                arr[i][j] = n;
            }
        }

        if(!isNotRipe) {
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                int nextCnt = cur[2] + 1;

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || arr[nextX][nextY] == -1)
                    continue;
                if(arr[nextX][nextY] == 0 || arr[nextX][nextY] > nextCnt){
                    arr[nextX][nextY] = nextCnt;
                    queue.offer(new int[]{nextX, nextY, nextCnt});
                }
            }
        }

        int minDay = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                minDay = Math.max(minDay, arr[i][j]);
            }
        }

        System.out.println(minDay);

    }
}
