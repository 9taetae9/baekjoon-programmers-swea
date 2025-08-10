import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Process(priorities[i], i));
        }
        
        int order = 0;
        while(!queue.isEmpty()){
            Process curr = queue.poll();
            
            boolean hasHigherPriority = false;
            for(Process p : queue){
                if(p.priority > curr.priority){
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if(hasHigherPriority){
                queue.offer(curr);
            }else{
                order++;
                if(curr.location == location){
                    return order;
                }
            }
        }
        
        
        
        return order;
    }
    
    private static class Process{
        int priority;
        int location;
        
        public Process(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
}