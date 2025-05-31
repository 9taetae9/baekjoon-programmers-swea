import java.util.*;

class Solution {
    Map<String, Integer> dict = new HashMap<>();
    
    {
        for(int i=0; i<26; i++){
            dict.put(String.valueOf((char)('A'+i)), i+1);
        }
    }
    
    public int[] solution(String msg) {
        int nextIdx = 27;
        List<Integer> answer = new ArrayList<>();
        
        int i = 0;
        while(i < msg.length()){
            
            String current = String.valueOf(msg.charAt(i));
            
            while(i + current.length() < msg.length() &&
                    dict.containsKey(current + msg.charAt(i + current.length()))){
                current += msg.charAt(i + current.length());
            }
            
            answer.add(dict.get(current));
            if(i + current.length() < msg.length()){
                dict.put(current+ msg.charAt(i + current.length()), nextIdx++);
                
            }
            i += current.length();
            
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
