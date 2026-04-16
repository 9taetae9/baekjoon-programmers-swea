import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    ans.add(bfs(i, j, maps, visited));
                }
            }
        }
        
        if(ans.size() == 0) return new int[]{-1};
        
        ans.sort(Comparator.naturalOrder());
        
        return ans.stream().mapToInt(i->i).toArray();
    }
    
    private int bfs(int c, int r, String[] maps, boolean[][] visited){
        Deque<int[]> queue = new ArrayDeque<>();
        
        int days = 0;
        days += maps[c].charAt(r) - '0';
        queue.offer(new int[]{c, r});
        
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length()) continue;
                
                if(maps[nx].charAt(ny) != 'X' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    days += maps[nx].charAt(ny) - '0';
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        return days;
    }
}