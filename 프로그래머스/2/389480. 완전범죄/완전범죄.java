import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    public int solution(int[][] info, int n, int m) {
        
        int len = info.length;
        //dp[a] = 도둑 A가 a 흔적을 남겼을 때 도둑 B의 최소 흔적
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        
        dp[0] = 0;  // 시작 전
        
        for(int i=0; i < len; i++){// 아이템 순회
            int[] newDp = new int[n];
            Arrays.fill(newDp, INF);
            
            for(int a=0; a<n; a++){
                if(dp[a] == INF){
                    continue;
                }
                
                //A가 훔칠 때
                int newA = a + info[i][0];
                if(newA < n){
                    newDp[newA] = Math.min(newDp[newA], dp[a]);
                }
                
                //B가 훔칠 때
                int newB = dp[a] + info[i][1];
                if(newB < m){
                    newDp[a] = Math.min(newDp[a], newB);
                }
            }
            
            dp = newDp;
        }
        
        for(int i=0; i<n; i++){
            if(dp[i] != INF){
                return i;
            }
        }
        
        return -1;
    }
}