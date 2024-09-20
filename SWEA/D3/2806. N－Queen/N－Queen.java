import java.util.*;
import java.io.*;

class Solution
{
    static int total;
    static int[] queen;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            queen = new int[N];
            total = 0;
            
            backtrack(0, N);
            System.out.println("#" + test_case +" " + total);
		}
	}
    
    private static void backtrack(int row, int N){
    	if(row == N){
            total++;
        	return ;
        }
        
        for(int col = 0; col < N; col++){
        	if(isSafe(row, col, N)){
                queen[row] = col;
            	backtrack(row+1, N);
            }
        }
    }
    
    private static boolean isSafe(int row, int col, int N){
    	for(int i = 0; i < row; i++){
        	if(queen[i] == col || Math.abs(i - row) == Math.abs(queen[i] - col)) return false;
        }
        return true;
    }
}