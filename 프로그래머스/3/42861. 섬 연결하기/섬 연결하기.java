import java.util.*;

class Solution {
    int[] parent;
    // int[] rank;
    public int solution(int n, int[][] costs) {
        parent = new int[n+1];
        // rank = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2],b[2]));
        
        int answer = 0;
        for(int[] cost : costs){
            if(find(cost[0]) != find(cost[1])){
                answer += cost[2];
                union(cost[0], cost[1]);
            }
        }
        
        return answer;
    }
    
    private void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }
     
    private int find(int x){
        if(parent[x] == x){
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
}