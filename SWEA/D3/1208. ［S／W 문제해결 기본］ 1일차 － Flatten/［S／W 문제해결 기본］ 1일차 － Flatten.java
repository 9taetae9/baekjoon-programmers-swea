import java.util.*;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int k = Integer.parseInt(br.readLine()); // 덤프 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] boxes = new int[100];
            
            for(int i = 0; i < 100; i++){
            	boxes[i] = Integer.parseInt(st.nextToken());
            }
			
            Arrays.sort(boxes);
            
            int flatten = 0;
            
            for(int i=0; i < k; i++){
                if(boxes[99] - boxes[0] <= 1){
                	break;
                }
            	boxes[99] -= 1;
                boxes[0] += 1;
                Arrays.sort(boxes);
            }
            
            flatten = boxes[99] - boxes[0];
            
            System.out.println("#" + test_case + " " + flatten);
            
		}
	}
}