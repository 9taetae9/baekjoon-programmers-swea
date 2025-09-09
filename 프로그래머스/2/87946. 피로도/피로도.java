class Solution {
    private int k;
    private int[][] dungeons;
    private boolean[] visited;
    
    private int max; 
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(0, 0);
        return max;
    }
    
    private void dfs(int cnt,int step){
        max = Math.max(max, cnt);
        
        if(step == dungeons.length) return;
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                k -= dungeons[i][1];
                dfs(cnt+1, step+1);
                k += dungeons[i][1]; 
                visited[i] = false;
            }else{
                dfs(cnt, step+1);
            }
        }
    }
}
/**
*/