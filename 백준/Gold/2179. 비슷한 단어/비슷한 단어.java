import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int maxPrefix = 0;
        int ansS = 0, ansT = 0;

        // 모든 단어쌍을 비교
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                int prefix = maxPrefix(words[i], words[j]);

                if(prefix > maxPrefix) {
                    maxPrefix = prefix;
                    ansS = i;
                    ansT = j;
                }
                else if(prefix == maxPrefix && prefix > 0) {
                    if(i < ansS || (i == ansS && j < ansT)) {
                        ansS = i;
                        ansT = j;
                    }
                }
            }
        }

        System.out.println(words[ansS]);
        System.out.println(words[ansT]);
    }

    private static int maxPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for(int i = 0; i < len; i++) {
            if(a.charAt(i) != b.charAt(i)) return i;
        }
        return len;
    }
}