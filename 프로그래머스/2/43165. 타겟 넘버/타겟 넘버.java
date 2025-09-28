class Solution {
    int len;
    int[] numbers;
    int target;
    int answer;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        this.numbers = numbers;
        this.target = target;
        
        getCount(0, 0);
        return answer;
    }
    
    private void getCount(int sum, int idx){
        if(idx == len){
            if(sum == target) answer++;
            return ;
        }
        
        
        getCount(sum + numbers[idx], idx+1);
        getCount(sum - numbers[idx], idx+1);
    }
}