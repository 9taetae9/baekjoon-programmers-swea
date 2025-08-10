import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] edge) {
        
        //그래프 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        //BFS 거리 계산
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        
        int start = 1;
        queue.offer(start);
        dist[start] = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int next : graph.get(curr)){
                if(dist[next] == -1){
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        
        int maxDist = 0;
        for(int d : dist){
            if(d > maxDist){
                maxDist = d;
            }
        }
        
        int count = 0;
        for(int d : dist){
            if(d == maxDist) count++;
        }
        
    
        return count;
    }
}