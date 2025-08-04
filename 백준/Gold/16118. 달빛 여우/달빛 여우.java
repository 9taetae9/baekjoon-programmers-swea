import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static class State implements Comparable<State> {
        int node;
        boolean isFast;
        double time;
        
        State(int node, boolean isFast, double time) {
            this.node = node;
            this.isFast = isFast;
            this.time = time;
        }
        
        public int compareTo(State other) {
            return Double.compare(this.time, other.time);
        }
    }
    
    static int N, M;
    static List<Edge>[] graph;
    static final double INF = Double.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            graph[a].add(new Edge(b, d));
            graph[b].add(new Edge(a, d));
        }
        
        // 최단거리 계산
        double[] foxDist = dijkstraFox();
        double[][] wolfDist = dijkstraWolf();
        
        // 결과 계산
        int answer = countFoxWins(foxDist, wolfDist);
        System.out.println(answer);
    }
    
    static double[] dijkstraFox() {
        double[] dist = new double[N + 1];
        Arrays.fill(dist, INF);
        
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new State(1, true, 0)); // 시작점, 상태는 의미없음
        
        while (!pq.isEmpty()) {
            State current = pq.poll();
            int node = current.node;
            double time = current.time;
            
            if (time > dist[node]) continue;
            
            for (Edge edge : graph[node]) {
                int next = edge.to;
                double nextTime = time + edge.weight; // 일정한 속도
                
                if (nextTime < dist[next]) {
                    dist[next] = nextTime;
                    pq.offer(new State(next, true, nextTime));
                }
            }
        }
        
        return dist;
    }
    
    // 늑대 - 상태 포함
    static double[][] dijkstraWolf() {
        //dist[node][state]: node에 state 상태로 도착할는 최단 시간
        // state 0: 다음에 빠르게 이동할 차례, state 1: 다음에 느리게 이동할 차례
        double[][] dist = new double[N + 1][2];
        
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }
        
        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[1][0] = 0;
        pq.offer(new State(1, true, 0));
        
        while (!pq.isEmpty()) {
            State current = pq.poll();
            int node = current.node;
            boolean isFast = current.isFast;
            double time = current.time;
            
            int stateIdx = isFast ? 0 : 1;
            if (time > dist[node][stateIdx]) continue;
            
            for (Edge edge : graph[node]) {
                int next = edge.to;
                double nextTime;
                boolean nextState;
                
                if (isFast) {
                    nextTime = time + edge.weight / 2.0;
                    nextState = false; // 다음은 느리게
                } else {
                    nextTime = time + edge.weight * 2.0;
                    nextState = true; // 다음은 빠르게
                }
                
                int nextStateIdx = nextState ? 0 : 1;
                if (nextTime < dist[next][nextStateIdx]) {
                    dist[next][nextStateIdx] = nextTime;
                    pq.offer(new State(next, nextState, nextTime));
                }
            }
        }
        
        return dist;
    }
          
    static int countFoxWins(double[] foxDist, double[][] wolfDist) {
        int count = 0;
        
        for (int i = 2; i <= N; i++) { 
            double foxTime = foxDist[i];
            double wolfTime = Math.min(wolfDist[i][0], wolfDist[i][1]);
            
            if (foxTime < wolfTime) {
                count++;
            }
        }
        
        return count;
    }
}