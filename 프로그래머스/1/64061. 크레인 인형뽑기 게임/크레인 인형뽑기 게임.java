import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int result = 0;

        for(int j=0; j<board[0].length; j++){
            for(int i=0; i<board.length; i++){
                if(board[i][j]!=0){
                   map.computeIfAbsent(j+1, k -> new ArrayDeque<>()).offer(board[i][j]);
                }
            }
        }

        for(int move : moves){
            if(map.containsKey(move) && !map.get(move).isEmpty()){
                    int item = map.get(move).poll();
                    if(!stack.isEmpty() && stack.peek() == item){
                        stack.pop();
                        result+=2;
                    }else{
                        stack.push(item);
                    }
            }
        }

        return result;
    }
}