import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        for(int i=0; i < discount.length - 9; i++){
            Map<String, Integer> tempMap = new HashMap<>(wantMap);
            for(int j=i; j < i+10; j++){
                String key = discount[j];
                if(!tempMap.containsKey(key)) {
                    break;
                }
                tempMap.computeIfPresent(key, (k, val) -> val > 1 ? val - 1 : null);
            }
            if(tempMap.size() == 0) answer++;
        }
        
        return answer;
    }
}