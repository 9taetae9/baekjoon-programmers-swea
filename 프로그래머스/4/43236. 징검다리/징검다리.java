import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int answer = 0;
        int left = 1;
        int right = distance;
        
        while(left <= right){
            int mid = left + (right - left)/2;
                
            int cnt = countRemovedRocks(rocks, mid, distance);
            
            if(cnt <= n){
                answer = mid;
                left = mid + 1;
            }else {//cnt > n
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private int countRemovedRocks(int[] rocks, int mid, int distance){
        int cnt = 0;
        int prev = 0;
        for(int rock : rocks){
            if(rock - prev < mid) cnt++;
            else prev = rock;
        }

        if(distance - prev < mid) cnt++;
        return cnt;
    }
}