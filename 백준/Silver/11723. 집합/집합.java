import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] S = new boolean[21];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i < M; i++){
            String[] query = br.readLine().split(" ");
            int n = 0;
            if(query.length == 2){
                n = Integer.parseInt(query[1]);
            }
            switch (query[0]){
                case "add" :
                    S[n] = true;
                    break;
                case "remove" :
                    S[n] = false;
                    break;
                case "check" :
                    sb.append(S[n] ? 1 : 0).append('\n');
                    break;
                case "toggle" :
                    S[n] = !S[n];
                    break;
                case "all" :
                    Arrays.fill(S, true);
                    break;
                case "empty" :
                    Arrays.fill(S, false);
                    break;
            }
        }

        System.out.println(sb);
    }
}
