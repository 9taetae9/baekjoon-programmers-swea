import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int target = wanho[0] + wanho[1];
        
        Arrays.sort(scores, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int rank = 1; 
        int maxPeerScore = 0;
        
        for(int[] score : scores){
            if(score[1] < maxPeerScore){
                if(score.equals(wanho)){
                    return -1;
                }
                continue;
            }
            else{
                maxPeerScore = Math.max(maxPeerScore, score[1]);
            }
            
            //완호보다 점수가 높으면 카운트 업
            if(score[0] + score[1] > target){
                rank++;
            }
        }
        
        return rank;
    }
}