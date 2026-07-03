class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        
        int answer = n;
        while(true){
            answer++;
            if(count == Integer.bitCount(answer)){
                break;
            }
        }
        
        return answer;
    }
}