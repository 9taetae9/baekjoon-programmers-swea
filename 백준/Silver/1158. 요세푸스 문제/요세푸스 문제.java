import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                Integer n = queue.poll();
                queue.add(n);
            }
            list.add(queue.poll());
        }

        System.out.print('<');
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i));
            if(i == list.size()-1){
                break;
            }
            System.out.print(", ");
        }
        System.out.print('>');
    }

}
