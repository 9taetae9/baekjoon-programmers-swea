import java.util.*;
class Solution {
    int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        arr= new int[rows][columns];
        int n = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = n++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            answer[i] = rotate(queries[i]);
        }
        
        
        return answer;
    }
    
    private int rotate(int[] query){
        int x1 = query[0]-1, y1 = query[1]-1;
        int x2 = query[2]-1, y2 = query[3]-1;
        
        int x = x1;
        int y = y1;
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        //오른쪽
        int min = 20000;
        while(y < y2){
            int num = arr[x][y++];
            min = Math.min(min, num);
            queue.offer(num);
        }    
            
        //아래
        while(x < x2){
            int num = arr[x++][y];
            min = Math.min(min, num);
            queue.offer(num);
        }
        //왼쪽
        while(y > y1){
            int num = arr[x][y--];
            min = Math.min(min, num);
            queue.offer(num);
        }
            
        //위
        while(x > x1){
            int num = arr[x--][y];
            min = Math.min(min, num);
            queue.offer(num);
        }
        
        x = x1; y= y1+1;
        //오른쪽
        while(y < y2){
            arr[x][y++] = queue.poll();
        }    
            
        //아래
        while(x < x2){
            arr[x++][y] = queue.poll();
        }
        //왼쪽
        while(y > y1){
            arr[x][y--] = queue.poll();
        }
            
        //위
        while(x >= x1){
            arr[x--][y] = queue.poll();
        }
        
        
        
        return min;
    }
}