class Solution {
    public int[] solution(int e, int[] starts) {
        int[] divisorCounts = new int[e+1];
        
        for(int i=1; i<=e; i++){
            for(int j=i; j<=e; j+=i){
                divisorCounts[j]++;
            }
        }
        
        int[] maxCountNum = new int[e+1];
        maxCountNum[e] = e;
        
        for(int i=e-1; i>=1; i--){
            int currentCount = divisorCounts[i];
            int nextBestNum = maxCountNum[i+1];
            int nextBestCount = divisorCounts[nextBestNum];
            
            if(currentCount >= nextBestCount){
                maxCountNum[i] = i;
            }else{
                maxCountNum[i] = nextBestNum;
            }
        }
        
        int[] answer = new int[starts.length];
        for(int k=0; k<answer.length; k++){
            answer[k] = maxCountNum[starts[k]];
        }
        
        return answer;
    }
}