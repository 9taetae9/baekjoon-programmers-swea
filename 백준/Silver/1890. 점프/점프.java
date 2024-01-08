import java.util.Scanner;

public class Main {
    static long[][] memo;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        memo = new long[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = sc.nextInt();
                memo[i][j] = -1;
            }
        }
        System.out.println(jump(board, 0, 0));

    }
    public static long jump(int[][] arr, int i, int j){
        if(i == arr.length-1 && j == arr.length-1  ) {
            return 1;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        memo[i][j] = 0;


        if(i+arr[i][j] < arr.length) {
            memo[i][j]+=jump(arr, i+arr[i][j], j);
        }

        if(j+arr[i][j] < arr.length) {
            memo[i][j] += jump(arr, i, j + arr[i][j]);
        }

        return memo[i][j];
    }

}