import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb_temp;
        for(int i=0; i<food.length; i++){
            int num = food[i]/2;
            sb.append(String.valueOf(i).repeat(num));
        }
        sb_temp = new StringBuilder(sb);
        sb.append("0");
        sb.append(sb_temp.reverse());
        
        
        
        return sb.toString();
    }
}