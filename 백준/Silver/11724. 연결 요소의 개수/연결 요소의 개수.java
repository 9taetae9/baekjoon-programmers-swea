import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N,M;
  static int[][] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new int[N+1][N+1];
    visited = new boolean[N+1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      graph[n1][n2] = 1;
      graph[n2][n1] = 1;
    }

    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
        cnt++;
      }
    }

    System.out.println(cnt);

  }

  private static void dfs(int cur) {
    visited[cur] = true;

    for (int i = 1; i <= N; i++) {
      if (!visited[i] && graph[cur][i] == 1) {
        dfs(i);
      }
    }
  }

}
