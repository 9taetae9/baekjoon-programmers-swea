import java.io.*;
import java.util.*;

public class Main {
    static int[][] G;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        G = new int[N][N];
        //그래프 인접행렬
        for(int i=0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int n=0; n < N; n++) { //거처가는 노드 n
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(G[i][n] == 1 && G[n][j] == 1){//i->n && n->j => i->j
                        G[i][j] = 1;
                    }
                }
            }
        }

        for(int[] g : G){
            for(int r : g){
                System.out.print(r+" ");
            }
            System.out.println();
        }
    }
}