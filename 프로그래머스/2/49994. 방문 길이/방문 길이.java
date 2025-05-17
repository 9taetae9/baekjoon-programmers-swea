import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    
    private void checkRoute(int x, int y, int nextX, int nextY){
        String p1 = "("+x+","+y+")";
        String p2 = "("+nextX+","+nextY+")";
        boolean visited = false;
        for(String s : list){
            if(s.contains(p1) && s.contains(p2)){
                visited = true;
                break;
            }
        }
        if(!visited) list.add(p1+p2);
    }
    
    public int solution(String dirs) {
        
        int x = 0, y = 0;
        for(char dir : dirs.toCharArray()){
            if(dir == 'U'){
                if(x-1 < -5) continue;
                int nextX = x-1, nextY = y;
                checkRoute(x, y, nextX, nextY);
                x = nextX; y = nextY;
            }else if(dir == 'D'){
                if(x+1 > 5) continue;
                int nextX = x+1, nextY = y;
                checkRoute(x, y, nextX, nextY);
                x = nextX; y = nextY;
            }else if(dir == 'R'){
                if(y+1 > 5) continue;
                int nextX = x, nextY = y+1;
                checkRoute(x, y, nextX, nextY);
                x = nextX; y = nextY;
            }else{//L
                if(y-1 < -5) continue;
                int nextX = x, nextY = y-1;
                checkRoute(x, y, nextX, nextY);
                x = nextX; y = nextY;
            }
        }
        return list.size();
    }
}