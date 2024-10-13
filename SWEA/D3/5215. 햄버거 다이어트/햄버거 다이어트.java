import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T= Integer.parseInt(br.readLine());
        
		StringBuilder sb = new StringBuilder();
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
            
            int[] dp = new int[L+1];
            
            for(int i=1; i <= N; i++){
                for(int j = L; j >= calorie[i]; j--){
                    dp[j] = Math.max(dp[j], dp[j - calorie[i]] + taste[i]); // 이전 단계 최적(현재 i 선택 x) vs [j- 현재 i 음식 칼로리] 한 상태의 최적  + 현재 i 점수
                }
            }
            
            
            sb.append("#").append(test_case).append(" ").append(dp[L]).append("\n");
            
		}
        
        System.out.print(sb);
	}
}