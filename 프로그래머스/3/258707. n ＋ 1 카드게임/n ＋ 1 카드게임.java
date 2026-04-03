import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        Set<Integer> original = new HashSet<>();
        Set<Integer> additional = new HashSet<>();
        
        int n = cards.length;
        int idx = n/3;
        int target = n + 1;
        
        for(int i=0; i<idx; i++){
            original.add(cards[i]);
        }
        
        int round = 1;
        while(idx < n){
            additional.add(cards[idx]);
            additional.add(cards[idx+1]);
            
            boolean isPassed = false;
            for(int card : original){
                if(original.contains(target - card) && card != target - card){
                    original.remove(card);
                    original.remove(target - card);
                    isPassed = true;
                    break;
                }
            }
            
            if(!isPassed && coin >= 1){
                for(int card : original){
                    if(additional.contains(target - card)){
                        original.remove(card);
                        additional.remove(target - card);
                        coin--;
                        isPassed = true;
                        break;
                    }
                }
            }
            
            if(!isPassed && coin >= 2){
                for(int card : additional){
                    if(additional.contains(target - card) && card != target - card){
                        additional.remove(card);
                        additional.remove(target - card);
                        coin -= 2;
                        isPassed = true;
                        break;
                    }
                }
            }
            
            if(!isPassed) break;
            
            round++;
            idx += 2;
        }
        
        return round;
    }
}