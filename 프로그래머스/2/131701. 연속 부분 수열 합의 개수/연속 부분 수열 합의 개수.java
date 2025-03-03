import java.util.*;
class Solution {
   static int[] cirElements;
    static Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        int len = elements.length;
        cirElements = new int[len*2];
        System.arraycopy(elements, 0, cirElements, 0, len);
        System.arraycopy(elements, 0, cirElements, len, len);
        
        int sum = 0;
        for(int i=1; i<=len; i++){
            getWays(i);
        }
        return set.size();
    }
    
    private void getWays(int len){
        
        for(int i=0; i<cirElements.length-len; i++){
            int sum = 0;
            for(int j=i; j < i+len; j++){
                sum += cirElements[j];
            }
            set.add(sum);
        }
    }
}