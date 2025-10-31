class Solution {
    final int INF = 20000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //floyd-warshall
        int[][] dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        
        for(int[] fare : fares){
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            
            dist[c][d] = f;
            dist[d][c] = f;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int k=1; k<=n; k++){
            answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        
        return answer;
    }
}