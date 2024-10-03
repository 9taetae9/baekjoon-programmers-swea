import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T= Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String memory = br.readLine();
            
            int cnt = 0;
            char current = '0';
            
            for(char c : memory.toCharArray()){
            	if(current != c){
                	current = c;
                    cnt++;
                }
            }
			
            System.out.println("#"+test_case+" " + cnt);

		}
	}
}