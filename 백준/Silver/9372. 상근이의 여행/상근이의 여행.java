import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static int T, N, M;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      graph = new ArrayList[N + 1];
      visited = new boolean[N + 1];
      for (int i = 1; i <= N; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        graph[n1].add(n2);
        graph[n2].add(n1);
      }
      System.out.println(bfs(1));
      Arrays.fill(visited, false);
    }

  }

  private static int bfs(int cur){
    int cnt = 0;
    visited[cur] = true;

    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(cur);

    while (!queue.isEmpty()) {
      int n = queue.poll();

      for (int e : graph[n]) {
        if (!visited[e]) {
          cnt++;
          visited[e] = true;
          queue.offer(e);
        }
      }

    }

    return cnt;
  }

}
