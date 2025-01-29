import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wishMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wishMap.put(want[i],number[i]);
        }
        
        int count = 0;
        for(int i=0; i<10; i++){
            if(wishMap.containsKey(discount[i])){
            wishMap.put(discount[i], wishMap.get(discount[i])-1);
            }
        }
        
        if(check(wishMap)) count++;
        
        for(int i=10; i < discount.length; i++){
            if(wishMap.containsKey(discount[i-10])){
                wishMap.put(discount[i-10], wishMap.get(discount[i-10])+1);
            }
            if(wishMap.containsKey(discount[i])){
                wishMap.put(discount[i], wishMap.get(discount[i])-1);
            }
            if(check(wishMap)) count++;
        }
        
        return count;
    }
    
    private boolean check(Map<String, Integer> wishMap){
        for(int value : wishMap.values()){
            if(value != 0) return false;
        }
        return true;
    }
}