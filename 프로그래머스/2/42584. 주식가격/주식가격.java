import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        int d;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i=1; i < len; i++){
            if(!stack.isEmpty() && prices[stack.peek()] > prices[i] ){
        d = stack.pop();
                ans[d] = i - d;
                while(!stack.isEmpty()){
                    if(prices[stack.peek()] > prices[i] ){
                            d = stack.pop();
                ans[d] = i - d;
                    }else{
                        break;
                    }
                }
                stack.push(i);
            }else{
                stack.push(i);
            }
        }
        
        while(!stack.isEmpty()){
            d = stack.pop();
            ans[d] = len-1 - d;
        }
        return ans;
    }
}