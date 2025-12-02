import java.util.*;

class Solution {
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    int maxSizeOfOneArea = 0;
    int m, n;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        this.m = m;
        this.n = n;
        
        boolean[][] visited = new boolean[m][n];
        int area = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                int c = picture[i][j];
                if(c == 0) continue;
                area++;
                bfs(i, j, c, picture, visited);
            }
        }
        
        
        return new int[]{area, maxSizeOfOneArea};
    }
    
    private void bfs(int x, int y, int target, int[][] arr, boolean[][] visited){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int size = 1;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == target){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
    }
}