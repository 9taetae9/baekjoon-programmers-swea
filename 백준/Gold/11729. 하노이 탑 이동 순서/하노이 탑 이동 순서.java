import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((1<<N)-1);
        move(1, 3, N);
        bw.flush();
    }

    private static void move(int s, int e, int n) throws IOException {
        if(n == 1) {
            bw.write(s+" "+e);
            bw.newLine();
            return;
        }
        move(s,6-(s+e),n-1);
        move(s, e, 1);
        move(6-(s+e), e, n-1);
    }
}