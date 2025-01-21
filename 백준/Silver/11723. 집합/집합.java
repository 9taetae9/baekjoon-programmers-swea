import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BitSet S = new BitSet(21);

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");

            switch (query[0]) {
                case "all" -> {
                    S.set(1, 21); // 1 ~ 20 까지 모든 비트 1로 설정

                    continue; // 1 ~ 20 까지 모든 비트 1로 설정
                }
                case "empty" -> {
                    S.clear();
                    continue;
                }
            }

            int n = Integer.parseInt(query[1]);
            switch (query[0]){
                case "add" -> S.set(n);
                case "remove" -> S.clear(n);
                case "check" -> sb.append(S.get(n) ? 1 : 0).append('\n');
                case "toggle" -> S.flip(n);
            }
        }
        System.out.println(sb);
    }
}