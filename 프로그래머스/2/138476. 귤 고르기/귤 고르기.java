import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int i : tangerine){
            countMap.put(i, countMap.getOrDefault(i,0)+1);
        }
        
        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts);
        
        int cnt=0;
        for(int i=counts.size()-1; i>=0; i--){
            k -= counts.get(i); cnt++;
            if(k<=0) return cnt;
        }
        
        return cnt;
    }
}