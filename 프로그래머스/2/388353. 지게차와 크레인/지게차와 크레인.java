import java.util.*;

class Solution {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};
    private int n, m;

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = storage[i].toCharArray();
        }

        for (String req : requests) {
            char target = req.charAt(0);
            if (req.length() == 2) {
                removeAll(grid, target);
            } else {
                removeEdge(grid, target);
            }
        }

        int remaining = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) remaining++;
            }
        }
        return remaining;
    }

    // 크레인: 모든 target 문자 전부 제거
    private void removeAll(char[][] grid, char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == target) {
                    grid[i][j] = 0;
                }
            }
        }
    }

    private void removeEdge(char[][] grid, char target) {
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> queue = new ArrayDeque<>();

        // 모든 경계 셀을 시작점으로 enqueue
        for (int i = 0; i < n; i++) {
            enqueue(i, 0, visited, queue);
            enqueue(i, m - 1, visited, queue);
        }
        for (int j = 0; j < m; j++) {
            enqueue(0, j, visited, queue);
            enqueue(n - 1, j, visited, queue);
        }

        // BFS 진행
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            // target이면 제거
            if (grid[x][y] == target) {
                grid[x][y] = 0;
                continue;
            }
            // 빈 칸이 아닌 경우 
            if (grid[x][y] != 0) {
                continue;
            }

            // 빈 칸이면 사방으로 확장
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    private void enqueue(int x, int y, boolean[][] visited, Deque<int[]> queue) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            queue.offer(new int[]{x, y});
        }
    }
}
