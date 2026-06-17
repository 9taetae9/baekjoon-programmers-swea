class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            String binaryString = Long.toBinaryString(numbers[i]);
            
            String paddedString = getPaddedBinary(binaryString);
            
            if(isValidBinary(paddedString, 0, paddedString.length() - 1)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private String getPaddedBinary(String binary){
        int length = binary.length();
        int h = 1;
        int nodeCount = 1; // 2^1 - 1
        
        while(nodeCount < length){
            h++;
            nodeCount = (1<<h) - 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nodeCount - length; i++){
            sb.append('0');
        }
        sb.append(binary);
        
        return sb.toString();
    }
    
    private boolean isValidBinary(String binary, int start, int end){
        if(start == end){
            return true;
        }
        
        int mid = start + (end - start) / 2;
        if(binary.charAt(mid) == '0'){
            for(int i=start; i<=end; i++){
                if(binary.charAt(i) == '1'){
                    return false;
                }
            }
            return true;
        }
        
        return isValidBinary(binary, start, mid - 1) && isValidBinary(binary, mid + 1, end);
    }
}