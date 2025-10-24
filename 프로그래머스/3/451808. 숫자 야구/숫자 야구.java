import java.util.function.Function;
import java.util.*;

class Solution {
    public int solution(int n, Function<Integer, String> submit) {
        // 1~9 수 중 서로 다른 4자리 수 조합
        List<Integer> candidates = new ArrayList<>();
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(j == i) continue;
                for(int k=1; k<=9; k++){
                    if(k == i || k == j) continue;
                    for(int l=1; l<=9; l++){
                        if(l == i || l == j || l == k) continue;
                        candidates.add(i*1000 + j*100 + k*10 + l);
                    }
                }
            }
        }
        
        // 후보가 1개 남을 때까지 반복
        while(candidates.size() > 1){
            int guess = candidates.get(0);
            String result = submit.apply(guess);
            
            if(result.equals("4S 0B")){
                return guess;
            }
            
            candidates.removeIf(candidate ->
                !isConsistent(guess, candidate, result)
            );
        }
        
        return candidates.get(0);
    }
    
    private boolean isConsistent(int guess, int candidate, String expectedResult){
        int[] guessDigits = getDigits(guess);
        int[] candidateDigits = getDigits(candidate);
        
        int strikes = 0;
        int balls = 0;
        
        for(int i=0; i<4; i++){
            if(guessDigits[i] == candidateDigits[i]) strikes++;
            else{
                for(int j=0; j<4; j++){
                    if(i != j && guessDigits[i] == candidateDigits[j]){
                        balls++;
                        break;
                    }
                }
            }
        }
        
        String result = strikes + "S " + balls + "B";
        return result.equals(expectedResult);
    }
    
    private int[] getDigits(int num){
        return new int[]{
            num / 1000,
            (num / 100) % 10,
            (num / 10) % 10,
            num % 10
        };
    }
}