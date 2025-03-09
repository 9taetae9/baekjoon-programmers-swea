import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        Deque<String> queue = new ArrayDeque<>();
        int time = 0;
        for(String city : cities){
            String s = city.toLowerCase();
            if(!queue.contains(s)){
                time += 5;
                if(queue.size() == cacheSize){
                    queue.poll();
                }
                queue.offer(s);
            }else{
                time+=1;
                queue.remove(s);
                queue.offer(s);
            }
        }
        
        
        return time;
    }
}