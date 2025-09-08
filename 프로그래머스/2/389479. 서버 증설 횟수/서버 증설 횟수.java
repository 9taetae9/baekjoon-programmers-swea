//시작 시간 11:37am
class Solution {
    
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[24];
        
        int total = 0;
        for(int i=0; i<24; i++){
            int required = players[i]/m;
            if(required > servers[i]){
                int need = required - servers[i];
                
                for(int j=i; j<24 && j<i+k; j++){
                    servers[j] += need;
                }
                
                total += need;
            }
        }    
        
        return total;
    }
}