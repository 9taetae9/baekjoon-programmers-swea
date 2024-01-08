import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int row = sc.nextInt();
       int col = sc.nextInt();

       int[][] arr = new int[row][col];
       for(int i=0; i<row; i++){
           for(int j=0; j<col; j++){
                arr[i][j] = sc.nextInt();
           }
       }

       int[][] presum = new int[row+1][col+1];

       for(int i=1; i<=row; i++){
           for(int j=1; j<=col; j++){
               presum[i][j] = arr[i-1][j-1] + presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1];
           }
       }

       int T = sc.nextInt();

       for(int i=0; i<T; i++){
           int row1 = sc.nextInt();
           int col1 = sc.nextInt();
           int row2 = sc.nextInt();
           int col2 = sc.nextInt();

           int result = presum[row2][col2] - presum[row1-1][col2] - presum[row2][col1-1] + presum[row1-1][col1-1];

           System.out.println(result);
       }

    }

}



//        2 3
//        1 2 4
//        8 16 32
//        3
//        1 1 2 3
//        1 2 1 2
//        1 3 2 3
//
//        63
//        2
//        36