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
                if(G[i][n] == 1) { //i->n 이 1이 아니면 skip
                    for (int j = 0; j < N; j++) {
                        if (G[i][j] == 0 && G[n][j] == 1) {// i->j 이 이미 1이면 skip, n->j이 1이면 i->j 는 1
                            G[i][j] = 1;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] g : G){
            for(int r : g){
                sb.append(r).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        
    }
}