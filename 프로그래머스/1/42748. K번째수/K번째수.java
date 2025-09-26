import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int[] temp = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(temp);
            
            int n = command[2];
            answer[i] = temp[n-1];
        }
        return answer;
    }
}