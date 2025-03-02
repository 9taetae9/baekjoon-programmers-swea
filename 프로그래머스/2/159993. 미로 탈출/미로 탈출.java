import java.util.*;
class Point{
    int x;
    int y;
    int time;

    public Point(int x, int y, int time){
      this.x = x;
      this.y= y;
      this.time = time;
    }

    public void setTime(int time) {
      this.time = time;
    }
  }
class Solution {
  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,1,-1};
  static Deque<Point> queue;
  static boolean[][] visited;

  public int solution(String[] maps) {
    int answer = 0;

    Point s,l;
    s = new Point(0,0,0);
    l = s;
    for(int i=0; i<maps.length; i++){
      for(int j=0; j<maps[0].length(); j++){
        if(maps[i].charAt(j) == 'S'){
          s = new Point(i,j,0);
        }else if(maps[i].charAt(j) == 'L'){
          l = new Point(i,j,0);
        }
      }
    }

    boolean foundL = false;
    visited = new boolean[maps.length][maps[0].length()];
    queue = new ArrayDeque<>();
    queue.offer(s);
      visited[s.x][s.y] = true;
    while(!queue.isEmpty()){
      Point cur = queue.poll();
      if(maps[cur.x].charAt(cur.y) == 'L') {
         //레버 찾음
          foundL = true;
        l.setTime(cur.time);
        break;
      }
      for(int i=0; i<4; i++){
        int nextX = cur.x + dx[i];
        int nextY = cur.y + dy[i];
        int time = cur.time + 1;
        if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length()) continue;
        if(maps[nextX].charAt(nextY) == 'X' || visited[nextX][nextY]) continue;
           visited[nextX][nextY] = true;
        queue.offer(new Point(nextX, nextY, time));
      }
    }
      
    if(!foundL) return -1;
      
     for(boolean[] v : visited){
         Arrays.fill(v, false);
     } 
    queue.clear();
      
    queue.offer(l);
      boolean foundE = false;
      visited[l.x][l.y] = true;
    while(!queue.isEmpty()){
      Point cur = queue.poll();
      if(maps[cur.x].charAt(cur.y) == 'E'){
        //Exit 찾음
          foundE = true;
        answer = cur.time;
        break;
      }
      for(int i=0; i<4; i++){
        int nextX = cur.x + dx[i];
        int nextY = cur.y + dy[i];
        int time = cur.time + 1;
        if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length()) continue;
        if(maps[nextX].charAt(nextY) == 'X' || visited[nextX][nextY]) continue;
          visited[nextX][nextY] = true;
        queue.offer(new Point(nextX, nextY, time));
      }
    }

    return foundE ? answer : -1;
  }
}