import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = new HashMap<>();
        for(String c : completion){
            completionMap.merge(c, 1, Integer::sum);
        }
        
        for(String p : participant){
            if(!completionMap.containsKey(p)) return p;
            
            int val = completionMap.get(p);
            if(val > 1){
                completionMap.put(p, val - 1);
            }else{
                completionMap.remove(p);
            }
        }
        
        return "";
    }
}