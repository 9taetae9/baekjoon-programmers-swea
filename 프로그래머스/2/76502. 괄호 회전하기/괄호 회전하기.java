import java.util.*;

class Solution {
    public int solution(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(isValid(s, i)) cnt++;
        }
        return cnt;
    }
    
    private boolean isValid(String s, int x){
        s = s.substring(x) + s.substring(0, x);
        
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            switch(c){
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default :
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}