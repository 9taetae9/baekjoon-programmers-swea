
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int num = Integer.parseInt(br.readLine());
            String searchStr = br.readLine();
            String sentence = br.readLine();
            
			int idx = 0;
            int cnt = 0;
            
            while( (idx = sentence.indexOf(searchStr, idx)) != -1){
            	idx += searchStr.length();
                cnt++;
            }
            
            System.out.println("#" + num +" " +cnt);
		}
	}
}