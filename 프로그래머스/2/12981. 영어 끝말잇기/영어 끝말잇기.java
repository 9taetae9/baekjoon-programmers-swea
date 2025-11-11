import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> set = new HashSet<>();
        
        int step = 0;
        int len = words.length;
        
        char prev = 'a';
        for(int i=0; i<len; i++){
            if(i%n == 0) step++;
            if(i != 0 && prev != words[i].charAt(0)){
                return new int[]{i%n + 1, step};
            }
            
            if(set.contains(words[i])){
                return new int[]{i%n + 1, step};
            }
            
            prev = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }
        
        return new int[]{0,0};
    }
}