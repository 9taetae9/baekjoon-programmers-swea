import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n%2!=0) {
            System.out.println(0);
            return;
        }

        int[] arr=new int[31];
        arr[0] = 1;
        arr[2] = arr[0]*3;



        for(int i=4; i<=n; i+=2){
            arr[i] = arr[i-2]*3;
            for(int j=i-4; j>=0; j-=2){
                arr[i] += arr[j]*2;
            }
        }

        System.out.println(arr[n]);




}


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}