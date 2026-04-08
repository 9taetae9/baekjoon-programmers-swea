import java.util.*;

class Solution {
    
    int minCost = Integer.MAX_VALUE;
    int n;
    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;
        
        int[] hintsCount = new int[n];
        dfs(0, 0, hintsCount, cost, hint);
        
        return minCost;
    }
    
    private void dfs(int stage, int currSum, int[] hintsCount, int[][] cost, int[][] hint){
        if(currSum >= minCost) return;
        
        if(stage == n){
            minCost = Math.min(minCost, currSum);
            return;
        }
        
        int hCounts = Math.min(hintsCount[stage], n-1);
        int pay = cost[stage][hCounts];
        currSum += pay;
        dfs(stage + 1, currSum, hintsCount, cost, hint);
        
        if(stage < n-1){
            currSum += hint[stage][0];
            for(int i=1; i<hint[stage].length; i++){
                hintsCount[hint[stage][i]-1]++;
            }
            
            dfs(stage + 1, currSum, hintsCount, cost, hint);
            
            for(int i=1; i<hint[stage].length; i++){
                hintsCount[hint[stage][i]-1]--;
            }
        }
        
    }
}