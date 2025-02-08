class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int result = 0;
        int levelL = 1; 
        int levelR = 100000;
        
        while(levelL < levelR){
            int mid = levelL + (levelR - levelL)/2;
            if(canSolve(mid, diffs, times, limit)){
                levelR = mid;
            }else {
                levelL = mid + 1;
            }
        }
        
        
        return levelR;
    }
    
    private boolean canSolve(int level, int[] diffs, int[] times, long limit){
        long total = 0;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= level){
                total += times[i];
            }else{
                total += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            }
        }
        
        return total <= limit;
    }
}

/*
이분탐색?
숙련도 최솟값

1 ~ 100000
*/