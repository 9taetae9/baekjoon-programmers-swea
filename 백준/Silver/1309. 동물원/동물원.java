import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[3];

        Arrays.fill(arr,1);

        for(int i=1; i<n; i++){
            int a0= arr[0];
            int a1= arr[1];
            int a2= arr[2];

            arr[0] = (a0+a1+a2)%9901;
            arr[1] = (a0+a2)%9901;
            arr[2] = (a0+a1)%9901;
        }

        System.out.println((arr[0]+arr[1]+arr[2])%9901);
        return ;
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}