import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            
            int[] taste = new int[N+1];
            int[] calorie = new int[N+1];
            
            for(int i=1; i <= N; i++){
            	st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
            	calorie[i] = Integer.parseInt(st.nextToken());
            }
            
            int[][] dp = new int[N+1][L+1];
            
            for(int i=1; i <= N; i++){
                for(int j=0; j <= L; j++){
                    if(calorie[i] <= j){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-calorie[i]] + taste[i]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            
            System.out.println("#"+ test_case+ " " + dp[N][L]);
            
		}
	}
}