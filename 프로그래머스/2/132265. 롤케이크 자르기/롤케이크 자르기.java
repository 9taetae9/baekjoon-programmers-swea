class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] left = new int[10001];
        int[] right = new int[10001];
        
        for(int t : topping){
            right[t]++;
        }
        
        int leftKinds = 0;
        int rightKinds = 0;
        
        for(int k : right){
            if(k > 0){
                rightKinds++;
            }
        }
        
        for(int i=0; i<topping.length - 1; i++){
            if(left[topping[i]] == 0){
                leftKinds++;
            }
            
            left[topping[i]]++;
            right[topping[i]]--;
            
            if(right[topping[i]] == 0){
                rightKinds--;
            }
            
            if(leftKinds == rightKinds){
                answer++;
            }
            
        }
        
        
        
        return answer;
    }
}