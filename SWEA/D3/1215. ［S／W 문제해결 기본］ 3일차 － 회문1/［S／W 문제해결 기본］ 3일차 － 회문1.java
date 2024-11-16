import java.util.*;
import java.io.*;

class Solution
{
    static char[][] arr = new char[8][8];
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int len = Integer.parseInt(br.readLine());
            
            for(int i=0; i<8; i++){
            	arr[i] = br.readLine().toCharArray();
            }
            
          	System.out.println("#" + test_case + " " + numOfPalin(len));  
		}
	}
    
    private static int numOfPalin(int len){
        int cnt =0;
    	for(int i=0; i <= 8-len; i++){
        	for(int j=0; j <8; j++){
            	if(isPalinRow(i, i+len-1, j)) cnt++;
                if(isPalinCol(i, i+len-1, j)) cnt++;
            }
        }
        return cnt;
    }
    
    private static boolean isPalinRow(int a, int b, int row){
    	while(a < b){
        	if(arr[row][a++] != arr[row][b--]) return false;
        }
        return true;
    }
    
    private static boolean isPalinCol(int a, int b, int col){
    	while(a<b){
            if(arr[a++][col] != arr[b--][col]) return false;
        }
        
        return true;
    }
}