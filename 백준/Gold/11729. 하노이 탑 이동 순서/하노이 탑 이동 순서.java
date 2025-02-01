import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((1<<N)-1);
        move(1,3,N);
        System.out.println(sb);
    }

    private static void move(int a, int c, int n){
        if(n == 1) {
            sb.append(a).append(" ").append(c).append("\n");
            return;}
        move(a,6-a-c,n-1);
        move(a,c,1);
        move(6-a-c, c, n-1);
    }
}
