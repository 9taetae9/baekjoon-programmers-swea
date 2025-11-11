import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int n = nums.length / 2;
        int s = set.size();
        return n <= s ? n : s;
    }
}