import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int[][] maps; 
    boolean[][] visited;
    Queue<int[]> queue;
    int n, m;
    int min = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        bfs();
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private void bfs(){
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currR = curr[0];
            int currC = curr[1];
            int moveCount = curr[2];
            if(currR == n - 1 && currC == m - 1){
                min = moveCount;
                return;
            }
            
            for(int i=0; i<4; i++){
                int nextR = currR + dr[i];
                int nextC = currC + dc[i];
                
                if(nextR >= n || nextR < 0 || nextC >= m || nextC < 0){
                    continue;
                }
    
                if(maps[nextR][nextC] == 1 && !visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    queue.add(new int[]{nextR, nextC, moveCount + 1});
                }
            }
        }
    }
}