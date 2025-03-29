class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        while(n>=1){
            int cnt = 0;
            for(int c : citations){
                if(c >= n) cnt++;
            }
            if(cnt >= n) return n;
            n--;
        }
        
        
        return n;
    }
}