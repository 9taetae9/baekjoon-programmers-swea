import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);
        int cnt = 0;
        int prevEnd = -1;
        
        for(int[] target : targets){
            int start = target[0];
            int end = target[1];
            
            if(start >= prevEnd){
                cnt++;
                prevEnd = end;
            }
        }
        
        
        return cnt;
    }
}

/*
두 번째 원소기준 오름차순
*/
