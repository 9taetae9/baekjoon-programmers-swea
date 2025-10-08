import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number){
            return 1;
        }
        
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i=0; i<=8; i++){
            dp.add(new HashSet<>());
        }
        
        for(int i=1; i<=8; i++){
            // N이 i번 연속된 수 넣기
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for(int j=1; j <= i; j++){
                int k = i - j;
                
                for(int num1 : dp.get(j)){
                    for(int num2 : dp.get(k)){
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if(num2 != 0){
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            
            if(dp.get(i).contains(number)){
                return i;
            }
        }
        
        return -1;
    }
}