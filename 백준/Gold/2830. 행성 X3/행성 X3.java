import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void scorecalculator(int[] people){
        long score = 0;
        int n = people.length;

        for(int bit = 0; bit<31; bit++) {//각 비트마다
            long countOne = 0;

            for(int person : people){
                if((person & (1<<bit)) != 0){
                    countOne++; // 1인 비트 개수 세기
                }
            }
            long countZero = n-countOne;
            score += (1L << bit) * countOne * countZero;
        }

        System.out.println(score);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];

        for(int i=0; i<N; i++){
            people[i]=Integer.parseInt(br.readLine().trim());
        }

        scorecalculator(people);
    }
}
