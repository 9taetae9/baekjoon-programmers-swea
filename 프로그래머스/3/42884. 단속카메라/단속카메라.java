import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cnt = 1;
        int prev = routes[0][1];
        for(int[] route : routes){
            if(prev < route[0] || prev > route[1]){
                cnt++;
                prev = route[1];
            }
        }
        
        return cnt;
    }
}