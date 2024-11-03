import java.io.*;
import java.util.*;

public class Main {
    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] graph;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight)); // 간선 양방향으로 연결
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            sb.append(checkDistance(start, end)).append("\n");
        }

        System.out.println(sb);
    }

    private static int checkDistance(int start, int end){
        int[] distance = new int[N];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();

            if(currentNode == end) return distance[currentNode];

            for(Edge next : graph[currentNode]){
                if(distance[next.to] == -1) { // 방문하지 않았던 노드만 방문
                    distance[next.to] = distance[currentNode] + next.weight;
                    queue.offer(next.to);
                }
            }
        }

        return distance[end];
    }
}
