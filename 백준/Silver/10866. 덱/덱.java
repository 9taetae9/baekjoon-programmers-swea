import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();

        String e;
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push_front":
                    deque.offerFirst(s[1]);
                    break;
                case "push_back":
                    deque.offerLast(s[1]);
                    break;
                case "pop_front":
                    e = deque.pollFirst();
                    System.out.println(e == null ? -1 : e);
                    break;
                case "pop_back":
                    e = deque.pollLast();
                    System.out.println(e == null ? -1 : e);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    e= deque.peekFirst();
                    System.out.println(e == null ? -1 : e);
                    break;
                case "back":
                    e = deque.peekLast();
                    System.out.println(e == null ? -1 : e);
                    break;
            }
        }

    }
}
