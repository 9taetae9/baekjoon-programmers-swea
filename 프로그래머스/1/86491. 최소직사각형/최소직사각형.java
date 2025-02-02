class Solution {
    public int solution(int[][] sizes) {
        int min = 1;
        int max = 1;
        for(int[] size : sizes){
            int a = size[0];
            int b = size[1];
            min = Math.max(min, Math.min(a,b));
            max = Math.max(max, Math.max(a,b));
        }
        
        return min*max;
    }
}