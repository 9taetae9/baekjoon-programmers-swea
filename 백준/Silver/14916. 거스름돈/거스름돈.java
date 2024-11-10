import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] idx = {0,-1,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==1 || n == 3){
            System.out.println(-1); return ;
        }
        if(n==2 || n == 5){
            System.out.println(1); return;
        }
        if(n==4){
            System.out.println(2); return;
        }
        
        int start = (n-1)/5 + 2;

        System.out.println(start + idx[(n-1)%5]);
    }
}
