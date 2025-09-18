import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        int prev = -1;
        for(int num : arr){
            if(num == prev) continue;
            answer.add(num);
            prev = num;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}