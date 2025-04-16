import java.util.*;
class Solution {
    char[] word;
    int len;
    public int solution(String s) {
        word = s.toCharArray();
        len = word.length;
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(isCorrect(i)) cnt++;
        }
        
        return cnt;
    }
    
    private boolean isCorrect(int idx){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<len; i++){
            char c = word[(idx+i)%len];
            
            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                
                char temp = stack.pop();
                if(!((c == ']' && temp == '[') ||
                  (c == '}' && temp == '{') ||
                  (c == ')' && temp == '('))){
                    return false;
                }
            
            }
        }
        
        return stack.isEmpty();
    }
}