import java.util.*;

class Solution {
    int n;
    int[][] wires;
    boolean[] visited;
    List<List<Integer>> graph;
    public int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;
        int answer = Integer.MAX_VALUE;
    
        generateGraph(n);
        
        for(int i=0; i < wires.length; i++){
            int c = getCountExcludeWire(wires[i]);
            int o = n - c;
            answer = Math.min(answer, Math.abs(c - o));
        }
        
        return answer;
    }
    
    private void generateGraph(int n){
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }        
    }
    
    private int getCountExcludeWire(int[] excludeWire){
        visited = new boolean[n+1];
        return dfs(excludeWire[0], excludeWire);
    }
    
    private int dfs(int node, int[] excludeWire){
        visited[node] = true;
        int count = 1;
        
        for(int next : graph.get(node)){
            if(!isExcluded(next, node, excludeWire) && !visited[next]){
                count += dfs(next, excludeWire);
            }
        }
        return count;
    }
    
    private boolean isExcluded(int next, int node, int[] excludeWire){
        return (next == excludeWire[0] && node == excludeWire[1] ||
               next == excludeWire[1] && node == excludeWire[0]);
    }
    
}