import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();

        int S = 0; // 비트마스크

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String cmd = st.nextToken();
//            int idx = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) - 1 : -1;
            String[] query = br.readLine().split(" ");

            switch (query[0]) {
                case "all" -> {
                    S = (1<<21) - 1;// 1 ~ 20 까지 모든 비트 1로 설정

                    continue; // 1 ~ 20 까지 모든 비트 1로 설정
                }
                case "empty" -> {
                    S = 0;
                    continue;
                }
            }

            int n = Integer.parseInt(query[1]);
            int mask = 1 << n;

            switch (query[0]){
                case "add" -> S |= mask; // n번쨰 비트 1로 설정
                case "remove" -> S &= ~mask; //n번째 비트 0으로 설정
                case "check" -> bw.write((S & mask) != 0 ? "1\n" : "0\n");// n번째 비트 확인
                case "toggle" -> S ^= mask; // n 번째 비트 뒤집기
            }
        }
        bw.flush();
    }
}