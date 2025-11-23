import java.util.*;

class Solution {
    static class Node{
        int num;
        int cost;
        
        Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //다익스트라
        int[] dist = new int[n+1];
        Arrays.fill(dist, 100001);
        dist[destination] = 0;
        
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] road : roads){
            graph.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
            graph.computeIfAbsent(road[1], k -> new ArrayList<>()).add(road[0]);
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        queue.offer(new Node(destination, 0));
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            
            if(!graph.containsKey(curr.num)) continue; 
            for(int next : graph.get(curr.num)){
                if( curr.cost + 1 < dist[next] ){
                    queue.offer(new Node(next, curr.cost + 1));
                    dist[next] = curr.cost + 1;
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            if(dist[sources[i]] == 100001){
                answer[i] = -1;
            }else{
                answer[i] =dist[sources[i]];
            }
        }
        
        
        return answer;
    }
}