import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    int minTurns = Integer.MAX_VALUE;
    int[][] globalM;
    boolean[][] visitedR;
    boolean[][] visitedB;
    int n = 0, m = 0;
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        globalM = maze;
        
        visitedR = new boolean[n][m];
        visitedB = new boolean[n][m];
        
        int rx = 0, ry = 0, bx = 0, by = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j] == 1){
                    rx = i;
                    ry = j;
                }else if(maze[i][j] == 2){
                    bx = i;
                    by = j;
                }
            }
        }
        
        visitedR[rx][ry] = true;
        visitedB[bx][by] = true;
        
        dfs(rx, ry, bx, by, 0);
        
        return minTurns == Integer.MAX_VALUE ? 0 : minTurns;
    }
    
    private void dfs(int rx, int ry, int bx, int by, int turns){
        if(turns >= minTurns) return ;
        
        boolean redArrived = (globalM[rx][ry] == 3);
        boolean blueArrived = (globalM[bx][by] == 4);
        
        if(redArrived && blueArrived){
            minTurns = Math.min(minTurns, turns);
            
            return ;
        }
        
        
        
        List<int[]> redMoves = getMoves(rx, ry, visitedR, redArrived);
        List<int[]> blueMoves = getMoves(bx, by, visitedB, blueArrived);
        
        
        
        for(int[] redMove : redMoves){
            for(int[] blueMove : blueMoves){
                int nrx = redMove[0];
                int nry = redMove[1];
                int nbx = blueMove[0];
                int nby = blueMove[1];
                
                if(nrx == nbx && nry == nby) continue;
                if(nrx == bx && nry == by && nbx == rx && nby == ry) continue;
                
                if(!redArrived) visitedR[nrx][nry] = true;
                if(!blueArrived) visitedB[nbx][nby] = true;
                
                dfs(nrx, nry, nbx, nby, turns + 1);
                
                if(!redArrived) visitedR[nrx][nry] = false;
                if(!blueArrived) visitedB[nbx][nby] = false;
                
            }
        }
    }
    
    private List<int[]> getMoves(int cx, int cy, boolean[][] visited, boolean arrived){
        List<int[]> moves = new ArrayList<>();
        if(arrived){
            moves.add(new int[]{cx, cy});
            return moves;
        }
        
        for(int i=0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && globalM[nx][ny] != 5){
                moves.add(new int[]{nx, ny});
            }
        }
        
        return moves;
    }
}