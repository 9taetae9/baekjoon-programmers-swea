class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;
        
        
        int answer = calculate(endTime) - calculate(startTime);
        if((startTime * 719 % 43200 == 0) || (startTime * 708 % 43200 == 0)){
            answer++;
        }
        if(endTime >= 43200 && startTime < 43200){
            answer--;
        }
        
        return answer;
    }
    
    private int calculate(int seconds){
        int c1 = seconds * 719 / 43200;
        int c2 = seconds * 708 / 43200;
        
        return c1 + c2;
    }
}