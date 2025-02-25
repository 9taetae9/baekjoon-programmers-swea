class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int target_b = Math.max(wallet[0], wallet[1]);
        int target_s = Math.min(wallet[0], wallet[1]);
        
        int bill_b = Math.max(bill[0], bill[1]);
        int bill_s = Math.min(bill[0], bill[1]);
        while(!(target_b >= bill_b && target_s >= bill_s)){
            answer++;
            bill_b/=2;
            if(bill_b < bill_s){
                int temp = bill_b;
                bill_b = bill_s;
                bill_s = temp;
            }
        }
        return answer;
    }
}