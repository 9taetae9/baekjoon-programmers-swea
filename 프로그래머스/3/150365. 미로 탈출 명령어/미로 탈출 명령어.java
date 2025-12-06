import java.util.*;

class Solution {
    
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        int move = Math.abs(r - x) + Math.abs(c - y);
        if(k < move) return "impossible";
        if((k - move) % 2 == 1) return "impossible";
     
        
        int cx = x, cy = y;
     
        
        
        StringBuilder sb = new StringBuilder();
        int remaining = k;
        while(remaining > 0){
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx > n || nx < 1 || ny > m || ny < 1) continue;
                
                int remainAfter = remaining - 1;
                
                move = Math.abs(r - nx) + Math.abs(c - ny);
                if(remainAfter < move) continue;
                if((remainAfter - move) % 2 == 1) continue;
                
                
                sb.append(dir[i]);
                remaining = remainAfter;
                cx = nx;
                cy = ny;
                break;
            }    
        }
        
        return sb.toString();
    }
}