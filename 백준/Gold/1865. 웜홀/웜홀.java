import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    
    static final int INF = 1000000000;
    static ArrayList<Edge> edges;
    static int[] dist;
    
    public static void solution(int n, int m, int w, int[][] station, int[][] wormhole) {
        edges = new ArrayList<>();
        // 양방향 도로 추가
        for (int i = 0; i < m; i++) {
            edges.add(new Edge(station[i][0], station[i][1], station[i][2]));
            edges.add(new Edge(station[i][1], station[i][0], station[i][2]));
        }
        // 웜홀 추가
        for (int i = 0; i < w; i++) {
            edges.add(new Edge(wormhole[i][0], wormhole[i][1], -wormhole[i][2]));
        }
        
        System.out.println(bellmanFord(n) ? "YES" : "NO");
    }
    
    public static boolean bellmanFord(int v) {
        dist = new int[v + 1];
        Arrays.fill(dist, 0); // 모든 정점의 거리를 0으로 초기화
        
        // V-1번 반복
        boolean updated = false;
        for (int i = 1; i < v; i++) {
            updated = false;
            for (Edge edge : edges) {
                if (dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    updated = true;
                }
            }
            // 더 이상 업데이트가 없다면 음의 사이클이 없는 것
            if (!updated) break;
        }
        
        // 음의 사이클 확인을 위한 한 번의 추가 반복
        if (updated) {
            for (Edge edge : edges) {
                if (dist[edge.to] > dist[edge.from] + edge.weight) {
                    return true; // 음의 사이클 존재
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            int[][] station = new int[M][3];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                station[j][0] = Integer.parseInt(st.nextToken());
                station[j][1] = Integer.parseInt(st.nextToken());
                station[j][2] = Integer.parseInt(st.nextToken());
            }
            
            int[][] wormhole = new int[W][3];
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                wormhole[j][0] = Integer.parseInt(st.nextToken());
                wormhole[j][1] = Integer.parseInt(st.nextToken());
                wormhole[j][2] = Integer.parseInt(st.nextToken());
            }
            
            solution(N, M, W, station, wormhole);
        }
    }
}