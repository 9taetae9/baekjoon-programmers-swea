import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int S = 0; // 비트마스크

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");

            switch (query[0]) {
                case "all" :
                    S = (1<<21) - 1;// 1 ~ 20 까지 모든 비트 1로 설정
                    continue; // 1 ~ 20 까지 모든 비트 1로 설정
                case "empty" :
                    S = 0;
                    continue;
            }

            int n = Integer.parseInt(query[1]);
            int mask = 1 << n;

            switch (query[0]){
                case "add" : S |= mask; break;// n번쨰 비트 1로 설정
                case "remove" : S &= ~mask; break; //n번째 비트 0으로 설정
                case "check" : sb.append((S & mask) != 0 ? 1: 0).append('\n'); break;
                case "toggle" : S ^= mask; break;// n 번째 비트 뒤집기
            }
        }
        System.out.println(sb);
    }
}