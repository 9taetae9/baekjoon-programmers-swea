import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int max_space = maxSpace(arr);

        System.out.println(max_space);

    }

    private static int maxSpace(int[][] arr){
        int len = Math.min(arr.length, arr[0].length);

        int max_space = 1;
        for(int l=len; l>1; l--){
            for(int i=0; i < arr.length - l + 1; i++){
                for(int j=0; j<arr[0].length - l + 1; j++){
                    if(arr[i][j] == arr[i+l-1][j] && arr[i][j+l-1] == arr[i+l-1][j+l-1] && arr[i+l-1][j]== arr[i+l-1][j+l-1]){
                        max_space = l * l;
                        return max_space;
                    }
                }
            }
        }


        return max_space;
    }
}