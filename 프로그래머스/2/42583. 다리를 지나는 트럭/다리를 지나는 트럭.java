import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>(bridge_length);
        
        for(int i=0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        int time = 0;
        int currentWeights = 0;
        int cnt = 0;
        int idx = 0;
        
        while(idx < truck_weights.length || cnt > 0){
            time++;
            
            int exit = bridge.poll();
            if(exit > 0){
                cnt--;
                currentWeights -= exit;
            }
            
            if(idx < truck_weights.length && currentWeights + truck_weights[idx] <= weight){
                bridge.offer(truck_weights[idx]);
                currentWeights += truck_weights[idx];
                cnt++; idx++;
            }else{
                bridge.offer(0);
            }
        }
        
        return time;
        
    }
}