import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        
        int[] leftDays = new int[len];
        for(int i=0; i<len; i++){
            leftDays[i] = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
        }
        
        int cnt = 1;
        int maxDays = leftDays[0];
        
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<len; i++){
            
            if(leftDays[i] <= maxDays){
                cnt++;
            }else{
                ans.add(cnt);
                cnt = 1;
                maxDays = leftDays[i];
            }
        }
        
        ans.add(cnt);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}