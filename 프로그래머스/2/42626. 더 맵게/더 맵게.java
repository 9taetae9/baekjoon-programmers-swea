import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville){
            queue.add(s);
        }
        
        int curr1 = -1;
        int step = 0;
        while(queue.size() > 1){
            curr1 = queue.poll();
            if(curr1 >= K) break;
            int curr2 = queue.poll();
            
            queue.add(curr1 + curr2 * 2);
            step++;
        }
        
        if(queue.size() == 1) {
            int e = queue.poll();
            return e >= K ? step : -1;
        }
        
        return curr1 >= K ? step : -1;
    }
}