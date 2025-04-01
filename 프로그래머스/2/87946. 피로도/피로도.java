class Solution {
    static boolean[] visited;
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return max;
    }
    
    private void dfs(int k, int count, int[][] dungeons){
        max = Math.max(max, count);
        for(int i=0; i<dungeons.length; i++){
            if(dungeons[i][0] <= k && !visited[i]){
                visited[i] = true;
                dfs(k - dungeons[i][1], count+1, dungeons);
                visited[i] = false;
            }
        }
    }
}