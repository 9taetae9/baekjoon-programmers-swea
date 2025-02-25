import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int X;
    static int step;
    static List<List<Integer>> edges = new ArrayList<>();
    static Deque<Integer> queue;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            edges.get(A).add(B);
        }

        visited = new boolean[N+1];
        bfs(X);
        List<Integer> sorted = new ArrayList<>(queue);
        Collections.sort(sorted);
        for (int i : sorted) {
            System.out.println(i);
        }
        if (queue.isEmpty()) {
            System.out.println(-1);
        }
    }

    private static void bfs(int here){
        queue = new ArrayDeque<>();
        visited[here] = true;
        queue.offer(here);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int cur = queue.poll();

                for (int con : edges.get(cur)) {
                    if (visited[con])
                        continue;
                    visited[con] = true;
                    queue.offer(con);
                }
            }
            step++;
            if(step == K){
                return;
            }
        }
    }
}
