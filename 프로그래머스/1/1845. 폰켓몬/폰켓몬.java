import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> pokemon = new HashMap<>();
        
        for(int num : nums){
            pokemon.put(num, pokemon.getOrDefault(num, 0)+1);
        }
        
        int len = pokemon.size();
        int max = nums.length / 2;
        return Math.min(max, len);
    }
}