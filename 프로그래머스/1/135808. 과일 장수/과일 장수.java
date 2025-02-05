import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        //정렬 후 m 단위로 자르기
        Arrays.sort(score);
        
        int boxes = score.length/m;
        
        int answer = 0;
        for(int i=1; i<=boxes; i++){
            answer += score[score.length-i*m] * m;
        }
        
        
        return answer;
    }
}