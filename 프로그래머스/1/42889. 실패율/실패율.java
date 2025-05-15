import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>(); //stage, 실패율
       
        
        for(int i=1; i<=N; i++){
            double total = 0.0, playing = 0.0;
            for(int stage : stages){
                if(stage >= i){
                    total++;
                    if(stage == i) playing++;
                }
                
            }
            map.put(i, total > 0 ? playing/total : 0);
        }
        
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((e1,e2) -> Double.compare(e2.getValue(), e1.getValue()));
        
        int[] arr = new int[N];
        int idx = 0;
        for(Map.Entry<Integer, Double> entry : entryList){
            arr[idx++] = entry.getKey();
        }
        
        
        return arr;
    }
}

/**
스테이지 도달 & 아직 플래이중  => 플레이어 수
스테이지 도달 => 플레이어 수
*/