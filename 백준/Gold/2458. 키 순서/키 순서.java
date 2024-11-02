import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] H = new boolean[N][N];

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u1 = Integer.parseInt(st.nextToken());
            int u2 = Integer.parseInt(st.nextToken());

            H[u1-1][u2-1] = true;
        }


        for(int k=0; k < H.length; k++) {
            for (int i = 0; i < H.length; i++) {
                if(i == k) continue;
                for (int j = 0; j < H.length; j++) {
                    if(H[i][k] && H[k][j]) {
                        H[i][j] = true;
                    }
                }
            }
        }

        int cnt=0;
        boolean know;
        for(int i=0; i < H.length; i++){
            know = true;
            for(int j=0; j < H.length; j++){
                if(i!=j && !H[i][j] && !H[j][i]){
                    know = false;
                }
            }
            if(know) cnt++;
        }

        System.out.println(cnt);
    }
}
