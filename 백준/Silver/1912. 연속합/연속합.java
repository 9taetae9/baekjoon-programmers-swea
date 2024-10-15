import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int max = -1000;
        int currentSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            currentSum = Math.max(num, currentSum+num);
            max = Math.max(max, currentSum);
        }

        System.out.println(max);
    }
}