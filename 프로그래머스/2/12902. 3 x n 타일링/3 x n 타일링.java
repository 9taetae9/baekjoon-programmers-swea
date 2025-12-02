class Solution {
    private final int MOD = 1_000_000_007;
    
    public int solution(int n) {
        if(n % 2 == 1) return 0;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[2] = 3;
        
        for(int i=4; i <= n; i+=2){
            long val = (3L * dp[i-2]) % MOD;
            
            for(int j=4; j <= i; j+=2){
                val = (val + 2L * dp[i-j]) % MOD;
            }
            
            dp[i] = (int) val;
        }
        
        return dp[n];
    }
}