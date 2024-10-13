import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double d = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

            System.out.println(ryuNum(d, r1, r2));
        }

    }

    private static int ryuNum(double d, int r1, int r2){
        if(r1 == r2 && d == 0) return -1;

        if(r1+r2 < d) return 0;
        if(r1+r2 == d) return 1;
        
        if(r2 < r1) {
            int temp = r2;
            r2 = r1;
            r1 = temp;
        }
        
        if(r2-r1 > d) return 0;
        if(r2 - r1 == d) return 1;
        return 2;
    }
}