import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //첫째 줄에 학생들의 수 N (2 ≤ N ≤ 500)과 두 학생 키를 비교한 횟수 M (0 ≤ M ≤ N(N-1)/2)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] H = new int[N][N];

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u1 = Integer.parseInt(st.nextToken());
            int u2 = Integer.parseInt(st.nextToken());

            H[u1-1][u2-1] = 1;  //자신보다 큰 사람
            H[u2-1][u1-1] = -1; //자신보다 작은 사람
        }


        for(int k=0; k < H.length; k++) {
            for (int i = 0; i < H.length; i++) {
                if(i == k) continue;
                for (int j = 0; j < H.length; j++) {
                    if(H[i][j] == 1 && H[j][k] == 1){ // j가 i보다 크고, k가 j보다 크면 => k는 i보다 큼
                        H[i][k] = 1;
                    } else if(H[i][j] == -1 && H[j][k] == -1){ // j가 i보다 작고, k가 j보다 작으면 => k는 i보다 작음
                        H[i][k] = -1;
                    }
                }
            }
        }

        for(int k=0; k < H.length; k++) {
            for (int i = 0; i < H.length; i++) {
                if(i == k) continue;
                for (int j = 0; j < H.length; j++) {
                    if(H[i][j] == 1 && H[j][k] == 1){ // j가 i보다 크고, k가 j보다 크면 => k는 i보다 큼
                        H[i][k] = 1;
                    } else if(H[i][j] == -1 && H[j][k] == -1){ // j가 i보다 작고, k가 j보다 작으면 => k는 i보다 작음
                        H[i][k] = -1;
                    }
                }
            }
        }




        //자신보다 큰 사람은 1, 작은사람은 -1로 저장되어있음
        //0인 경우 => 자기 자신 or 키 비교를 못하는 경우

        //자기 자신에 해당 해당하는 열 제외하곤 -1 또는 1이 체크 되어 있어야 자신의 순서를 정확히 알 수 있음
        int cnt=0;
        boolean know;
        for(int i=0; i < H.length; i++){
            know = true;
            for(int j=0; j < H.length; j++){
                if(i==j) continue; // 자기 자신
                if(H[i][j] == 0) {  // 비교 못하는 경우
                    know = false;
                    break;
                }
            }

            if(know) cnt++;
        }


        System.out.println(cnt);
    }
}
