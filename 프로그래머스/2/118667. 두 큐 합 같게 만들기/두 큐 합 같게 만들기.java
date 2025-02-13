class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        int[] arr = new int[len*2];
        System.arraycopy(queue1, 0, arr, 0, len);
        System.arraycopy(queue2, 0, arr, len, len);
        
        
        
        long sum1 = 0;
        for(int q : queue1){
            sum1 += q;
        }
        long sum2 = 0;
        for(int q : queue2){
            sum2 += q;
        }
        long total = sum1 + sum2;
        if(total % 2 != 0) return -1;
        
        long target = total / 2;    
        int p1 = 0, p2 = len;
        
        while(p1 < p2 && p1 < 2*len && p2 < 2*len){
            if(sum1 == target){
                return p1 + (p2 - len);
            }else if(sum1 > target){
                sum1 -= arr[p1];
                p1++;
            }else {
                sum1 += arr[p2];
                p2++;
            }
        }
        
        
        return (sum1 == target) ? p1 + (p2 - len) : -1;
    }
}