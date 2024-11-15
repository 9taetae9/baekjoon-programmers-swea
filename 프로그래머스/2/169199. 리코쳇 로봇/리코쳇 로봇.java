import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0, -1, 1};
    static boolean[][] visited;
    public int solution(String[] board) {
        int rx=0, ry=0, gx=0, gy=0;
        int verLen = board.length;
        int horLen = board[0].length();
        for(int i=0; i<verLen; i++){
            for(int j=0; j<horLen; j++){
                if(board[i].charAt(j) == 'R'){
                    rx = i; ry = j;
                }
                if(board[i].charAt(j) == 'G'){
                    gx = i; gy = j;
                }
            }
        }
    
        return bfs(rx, ry, gx, gy, board);
    }
    
    private int bfs(int x, int y, int gx, int gy, String[] board){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited = new boolean[board.length][board[0].length()];
        visited[x][y] = true;
        
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0]==gx && curr[1] == gy) return curr[2];
            
            
            for(int i=0; i<4; i++){
                int nextX = curr[0]; 
                int nextY = curr[1];
                
                while(nextX + dx[i] >=0 && nextX + dx[i] < board.length && nextY + dy[i] >= 0 && nextY + dy[i] < board[0].length() && board[nextX + dx[i]].charAt(nextY + dy[i]) != 'D'){
                    nextX += dx[i];
                    nextY += dy[i];
                }
                
                
                if(!visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX,nextY,curr[2]+1});
                }
            }
        }
        
        
        return -1;
    }
}