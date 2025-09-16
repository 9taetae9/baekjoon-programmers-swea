import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0, y = 0;
        int answer = 0;
        
        Set<String> visited = new HashSet<>();
        
        for(char c : dirs.toCharArray()){
            int nx = x, ny = y;
            
            switch(c){
                case 'U': ny = y + 1; break;
                case 'D': ny = y - 1; break;
                case 'L': nx = x - 1; break;
                case 'R': nx = x + 1; break;
                default: continue;
            }
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5){
                continue;
            }
            
            String edgeKey = makeEdgeKey(x, y, nx, ny);
            
            if(!visited.contains(edgeKey)){
                visited.add(edgeKey);
                answer++;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    // (x1, y1)-(x2,y2) 간선을 무방향으로 표현하는 정규화 함수
    // 좌표 비교로 작은 쪽을 앞에 위치 시킨 문자열 반환
    static String makeEdgeKey(int x1, int y1, int x2, int y2){
        if(x1 < x2 || (x1 == x2 && y1 < y2)){
            return x1 + "," + y1 +"-"+x2+","+y2;
        }
        return x2 + "," + y2 +"-"+x1+","+y1; 
    }
}