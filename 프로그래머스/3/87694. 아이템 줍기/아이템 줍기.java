import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    int[][] board;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
      
        
        board = new int[101][101];
        
        for(int[] r : rectangle){
            int lx = r[0]*2;
            int ly = r[1]*2;
            int rx = r[2]*2;
            int ry = r[3]*2;
            
            for(int i=lx; i<=rx; i++){
                for(int j=ly; j<=ry; j++){
                    if(i != lx && i != rx && j != ly && j != ry){
                        board[i][j] = 2;
                    }else if(board[i][j] != 2){
                        board[i][j] = 1;
                    }
                }
            }
        }
        
        
        return bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);
    }

    private int bfs(int sX, int sY, int eX, int eY){
        boolean[][] visited = new boolean[101][101];
        
        Deque<int[]> queue = new ArrayDeque<>();
        visited[sX][sY] = true;
        queue.offer(new int[]{sX, sY, 0});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            if(curr[0] == eX && curr[1] == eY){
                return curr[2] / 2;
            }
            for(int i=0; i<4; i++){
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if(nx >= 0 && nx < 101 && ny >= 0 && ny < 101){
                    if(!visited[nx][ny] && board[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, curr[2]+1});
                    }   
                }
            }
        }
        
        return 0;
        
    }
}