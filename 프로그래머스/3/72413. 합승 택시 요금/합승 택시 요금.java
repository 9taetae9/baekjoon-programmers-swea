import java.util.*;

class Solution {
    class Edge{
        int to;
        int cost;
        
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares){
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            
            graph.get(c).add(new Edge(d, f));
            graph.get(d).add(new Edge(c, f));
        }
        
        int[] distFromS = dijkstra(s, n, graph);
        int[] distFromA = dijkstra(a, n, graph);
        int[] distFromB = dijkstra(b, n, graph);
        
        int answer = Integer.MAX_VALUE;
        for(int k = 1; k<=n; k++){
            //s -> k + k -> a + k -> b
            answer = Math.min(answer, distFromS[k] + distFromA[k] + distFromB[k]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int start, int n, List<List<Edge>> graph){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currNode = curr.to;
            int currCost= curr.cost;
            
            if(currCost > dist[currNode]){
                continue;
            }
            
            for(Edge next : graph.get(currNode)){
                int nextNode = next.to;
                int nextCost = currCost + next.cost;
                
                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pq.offer(new Edge(nextNode, nextCost));
                }
            }
        }
        
        return dist;
    }
}