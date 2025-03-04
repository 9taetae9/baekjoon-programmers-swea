import java.util.*;
class Solution {
    public String solution(int n) {
        StringBuilder sb  = new StringBuilder();
        while(n > 0){
            int r = n % 3;
            if(r == 0){
                n = n/3 - 1; 
                sb.append(4);
            }else{
                n/=3;
                sb.append(r);
            }
        }
        
        return sb.reverse().toString();
    }
}