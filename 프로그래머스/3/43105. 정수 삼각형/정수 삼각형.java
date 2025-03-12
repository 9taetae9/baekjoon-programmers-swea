class Solution {
    public int solution(int[][] triangle) {
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<i+1; j++){
                if(j==0) triangle[i][j] += triangle[i-1][j];
                else if(j==i) triangle[i][j] += triangle[i-1][j-1];
                else
                triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }
        
        int max = 0;
        for(int sum : triangle[triangle.length-1]){
            max = Math.max(sum, max);
        }
        
        
        return max;
    }
}