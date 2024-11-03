import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph[v1].add(new Edge(v2, weight));
            graph[v2].add(new Edge(v1, weight));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            sb.append(getDistance(v1, v2)).append("\n");
        }

        System.out.print(sb);
    }

    static private int getDistance(int start, int end) {
        int[] distance = new int[N];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == end) {
                return distance[currentNode];
            }

            for (Edge e : graph[currentNode]) {
                if (distance[e.to] == -1) {
                    distance[e.to] = distance[currentNode] + e.weight;
                    queue.offer(e.to);
                }
            }
        }

        return distance[end];
    }
}
