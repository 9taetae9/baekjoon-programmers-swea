import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    int solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                cost[i][j] += Math.min(cost[i-1][(j+1)%3], cost[i-1][(j+2)%3]);
            }
        }
        
        return Math.min(cost[N-1][0], Math.min(cost[N-1][1],cost[N-1][2]));
    }
    
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        System.out.println(m.solution());
    }
}