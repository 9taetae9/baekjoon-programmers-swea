import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine()); //N : 자격얻은 사람 수, M : 걸리는 시간  K: 만드는 개수
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[] count = new int[11120];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i < N; i++){
            	count[Integer.parseInt(st.nextToken()) / M]++;
            }
            boolean isPossible = true;
            int arrived = 0;
            for(int i=0; i < count.length; i++){
            	arrived += count[i];
                if(arrived > K * i){
                    isPossible = false;
                	break;
                }
            }
            
            String s = isPossible ? "Possible" : "Impossible";
            System.out.println("#"+test_case+" "+ s);
		}
	}
}