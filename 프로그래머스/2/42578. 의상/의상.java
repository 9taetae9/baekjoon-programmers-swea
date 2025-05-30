import java.util.*;
class Solution {
    Map<String, Integer> count = new HashMap<>();
    
    public int solution(String[][] clothes) {
        for(String[] c : clothes){
            count.merge(c[1], 1, Integer::sum);
        }
        
        int answer = 1;
        
        for(int n : count.values()){
            answer *= n+1;
        }
        
        return answer-1;
    }
}

/**
오늘: 동그란 안경, 파란 티셔츠, 긴 코트
다음날: 청바지 or 동그란 대신 검정 선글라스
종류별 최대 1가지

*/