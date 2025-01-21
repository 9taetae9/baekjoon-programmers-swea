import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static boolean[][] visitedF;
    static boolean[][] visitedJ;
    static char[][] arr;
    static int[][] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        times = new int[R][C];
        visitedF = new boolean[R][C];
        visitedJ = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
            Arrays.fill(times[i], Integer.MAX_VALUE); // 최대값으로 초기화
        }

        Queue<int[]> queueF = new ArrayDeque<>();
        Queue<int[]> queueJ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'F') {
                    visitedF[i][j] = true;
                    queueF.offer(new int[]{i, j});
                    times[i][j] = 0; // 불의 초기 시간은 0
                }
                if (arr[i][j] == 'J') {
                    visitedJ[i][j] = true;
                    queueJ.offer(new int[]{i, j, 0}); // 지훈의 초기 시간
                }
            }
        }

        // 불 확산 처리
        while (!queueF.isEmpty()) {
            int[] cur = queueF.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || visitedF[nextX][nextY] || arr[nextX][nextY] == '#')
                    continue;

                visitedF[nextX][nextY] = true;
                times[nextX][nextY] = times[cur[0]][cur[1]] + 1; // 시간 갱신
                queueF.offer(new int[]{nextX, nextY});
            }
        }

        // 지훈 이동 처리
        while (!queueJ.isEmpty()) {
            int[] cur = queueJ.poll();
            int curTime = cur[2];

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                // 탈출 조건
                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
                    System.out.println(curTime + 1);
                    return;
                }

                if (visitedJ[nextX][nextY] || arr[nextX][nextY] == '#') continue;

                // 불 시간과 비교
                if (curTime + 1 >= times[nextX][nextY]) continue;

                visitedJ[nextX][nextY] = true;
                queueJ.offer(new int[]{nextX, nextY, curTime + 1});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
