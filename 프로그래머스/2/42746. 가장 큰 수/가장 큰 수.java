import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int len = numbers.length;
        String[] numStr = new String[len];
        for(int i=0; i < len; i++){
            numStr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numStr, (a, b) -> (b + a).compareTo(a + b));
        
        if(numStr[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String n : numStr){
            sb.append(n);
        }
        
        return sb.toString();
    }
}