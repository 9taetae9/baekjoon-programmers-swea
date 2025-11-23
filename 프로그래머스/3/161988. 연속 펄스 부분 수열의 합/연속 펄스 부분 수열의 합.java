class Solution {
    public long solution(int[] sequence) {
        long p1Sum = 0;
        long p2Sum = 0;
        
        int pulse = -1;
        
        long answer = Long.MIN_VALUE;
        for(int num : sequence){
            long val1 = num * pulse;
            long val2 = num * (-pulse);
            
            p1Sum = Math.max(val1, p1Sum + val1);
            p2Sum = Math.max(val2, p2Sum + val2);
            
            answer = Math.max(answer, Math.max(p1Sum, p2Sum));
            
            pulse *= -1;
        }
        
        
        return answer;
    }
}