import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> stack = new ArrayDeque<>();
        int cnt = 0;
        for(int move : moves){
            move--;
            for(int i=0; i<board.length; i++){
                if(board[i][move] != 0){
                    int tmp = board[i][move];
                    if(!stack.isEmpty() && stack.peek() == tmp){
                        stack.pop();
                        cnt+=2;
                    }else{
                        stack.push(tmp);
                    }
                    board[i][move] = 0;
                    break;
                }
            }
        }
        return cnt;
    }
}