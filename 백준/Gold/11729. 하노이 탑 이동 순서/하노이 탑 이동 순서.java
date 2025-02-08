import java.io.*;

public class Main {
    static BufferedWriter bw;
    static char[] buffer;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 필요한 버퍼 크기 계산: 각 줄은 최대 4글자 (두 숫자 + 공백 + 개행)
        // 총 이동 횟수는 2^N - 1
        int moves = (1 << N) - 1;
        buffer = new char[4 * moves];

        bw.write(String.valueOf(moves));
        bw.write('\n');

        hanoi(N, '1', '2', '3');

        bw.write(buffer, 0, idx);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void hanoi(int n, char from, char aux, char to) throws IOException {
        if (n == 1) {
            buffer[idx++] = from;
            buffer[idx++] = ' ';
            buffer[idx++] = to;
            buffer[idx++] = '\n';
            return;
        }

        hanoi(n - 1, from, to, aux);
        buffer[idx++] = from;
        buffer[idx++] = ' ';
        buffer[idx++] = to;
        buffer[idx++] = '\n';
        hanoi(n - 1, aux, from, to);
    }
}