import java.io.*;
import java.io.*;

public class Main {
    static int total;
    static int[] queen;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        total = 0;
        queen = new int[N];
        
        backtrack(0, N);
        System.out.println(total);
    } 
    
    private static void backtrack(int row, int N){
        if(row == N){
            total++;
            return ;
        }
        for(int col=0; col < N; col++ ){
            if(isSafe(row, col, N)){
                queen[row] = col;
                backtrack(row+1, N);
            }
        }
    }
    
    private static boolean isSafe(int row, int col, int N){
        for(int i=0; i < row; i++){
            if(queen[i] == col || Math.abs(i - row) == Math.abs(queen[i] - col))
                return false;
        }
        return true;
    }

    

}
