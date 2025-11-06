import java.util.*;

class Solution {
    
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    
    char[][] board;
    
    public int solution(String[] board) {
        this.board = new char[board.length][board[0].length()]; 
        for(int i = 0; i<this.board.length; i++){
            this.board[i] = board[i].toCharArray();
        }
        
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        for(int i = 0; i<this.board.length; i++){
            for(int j = 0; j < this.board[0].length; j++){
                if(this.board[i][j] == 'R'){
                    startX = i;
                    startY = j;
                }else if(this.board[i][j] == 'G'){
                    endX = i;
                    endY = j;
                }
            }
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int[] next = move(cur, i);
                
                if(this.board[next[0]][next[1]] == 'G') return next[2];
                if(this.board[next[0]][next[1]] == '.'){
                    this.board[next[0]][next[1]] = 'x';
                    q.offer(new int[]{next[0], next[1], next[2]});
                }
                
            }
        }
        
        return -1;
    }
    
    private int[] move(int[] cur, int dir){
        int curX = cur[0];
        int curY = cur[1];
        
        while(!(curX < 0 || curX >= board.length || curY < 0 || curY >= board[0].length)){
            if(board[curX][curY] == 'D') break;
            curX += dx[dir];
            curY += dy[dir];
        }
        
        return new int[]{curX - dx[dir], curY - dy[dir], cur[2]+1};
    }
}