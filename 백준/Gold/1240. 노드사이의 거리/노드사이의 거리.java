import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Edge>[] graph;
    static int[] depth;
    static int[][] parent;
    static int[][] distance;
    static int maxLevel;

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w));
        }

        maxLevel = (int) (Math.log(N) / Math.log(2));
        depth = new int[N + 1];
        parent = new int[N + 1][maxLevel + 1];
        distance = new int[N + 1][maxLevel + 1];

        dfs(1, 0, 0);
        fillParent();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getDistance(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node, int parent, int dist) {
        depth[node] = depth[parent] + 1;
        Main.parent[node][0] = parent;
        distance[node][0] = dist;

        for (Edge e : graph[node]) {
            if (e.to != parent) {
                dfs(e.to, node, e.weight);
            }
        }
    }

    static void fillParent() {
        for (int i = 1; i <= maxLevel; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
                distance[j][i] = distance[j][i - 1] + distance[parent[j][i - 1]][i - 1];
            }
        }
    }

    static int getDistance(int a, int b) {
        int dist = 0;
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = maxLevel; i >= 0; i--) {
            if (depth[a] - depth[b] >= (1 << i)) {
                dist += distance[a][i];
                a = parent[a][i];
            }
        }

        if (a == b) return dist;

        for (int i = maxLevel; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                dist += distance[a][i] + distance[b][i];
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        dist += distance[a][0] + distance[b][0];
        return dist;
    }
}