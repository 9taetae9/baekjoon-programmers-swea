import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(String s: keymap){
            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c) && map.get(c) <= i+1) continue;
                map.put(c, i+1);
            }
        }
        
        int[] ans = new int[targets.length];
        int idx = 0;
        for(String target : targets){
            int sum = 0;
            for(char c : target.toCharArray()){
                if(!map.containsKey(c)){
                    sum = -1;
                    break;
                }
                sum += map.get(c);
            }
            ans[idx++]=sum;
        }
        
        
        return ans;
    }
}