class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int n = sequence.length;
        int minLen = n;
        int[] answer = new int[2];
        
        while(right < n){
            if(sum == k){
                if(minLen > right - left){
                    minLen = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left++];
            }else if(sum > k){
                sum -= sequence[left++];
            }else{
                right++;
                if(right < n){
                    sum+= sequence[right];
                }
            }
        }
        
        return answer;
    }
}