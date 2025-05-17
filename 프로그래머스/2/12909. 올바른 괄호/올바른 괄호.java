import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            else if(!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}