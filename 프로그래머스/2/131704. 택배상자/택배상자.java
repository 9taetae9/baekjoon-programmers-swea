import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=order.length; i>0; i--){
            stack.push(i);
        }
        
        int res = 0;
        Deque<Integer> stack2 = new ArrayDeque<>();
        for(int num : order){
            while(true){
                if(!stack.isEmpty() && stack.peek() == num){
                    stack.pop();
                    res++;
                    break;
                }else if(!stack2.isEmpty() && stack2.peek() == num){
                    stack2.pop();
                    res++;
                    break;
                }else{
                    if(stack.isEmpty()) return res;
                    int n = stack.pop();
                    stack2.push(n);
                }
            }
        }
        return res;
    }
}

// class Solution {
//     public int solution(int[] order) {
//         int res = 1;
//         for(int i=0; i < order.length-1; i++){
//             if(Math.abs(order[i]-order[i+1]) == 1) res++;
//             else break;
//         }
//         return res;
//     }
// }
/*
시작 지점 연속된 수열 길이? => 기본 테케만 통과 
*/