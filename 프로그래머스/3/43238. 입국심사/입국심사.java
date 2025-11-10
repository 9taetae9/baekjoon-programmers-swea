class Solution {
    public long solution(int n, int[] times) {
        long left = Integer.MAX_VALUE;
        long right = Integer.MAX_VALUE;
        for(int time : times){
            left = Math.min(left, time);
            right = Math.min(right, time);
        }
        right *= n;
        
        long answer = 0;
        while(left <= right){
            long mid = left + (right - left) / 2;
            
            long sum = 0;
            for(int time : times){
                
                sum += mid / time;
            }
            
            if(sum >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}