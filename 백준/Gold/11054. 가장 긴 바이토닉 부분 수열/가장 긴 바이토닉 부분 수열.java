import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] Idp = new int[N]; //증가
        int[] Ddp = new int[N]; //감소
        Arrays.fill(Idp, 1);
        Arrays.fill(Ddp, 1);



        for(int i=1; i < N; i++){
            for(int j=0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    Idp[i] = Math.max(Idp[i], Idp[j] + 1);
                }
            }
        }

        for(int i=N-2; i >= 0; i--){
            for(int j=N-1; j > i; j--){
                if(sequence[i] > sequence[j]){
                    Ddp[i] = Math.max(Ddp[i], Ddp[j]+1);
                }
            }
        }

        int maxLen = 1;
        for(int i=0; i<N; i++){
            maxLen = Math.max(maxLen, Idp[i]+Ddp[i]-1);
        }

        System.out.println(maxLen);
    }
}