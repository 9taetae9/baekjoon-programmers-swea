import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        // 큐에 존재하는 숫자의 개수를 추적
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String op : operations){
            String[] parts = op.split(" ");
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);
            
            if(command.equals("I")){
                minPq.add(value);
                maxPq.add(value);
                map.put(value, map.getOrDefault(value, 0)+1);
            }else if(command.equals("D")){
                if(map.isEmpty()){
                    continue;
                }
                if(value == 1){
                    removeValue(maxPq, map);
                }else{ // value == -1
                    removeValue(minPq, map);
                }
            }
        }
        
        if(map.isEmpty()){
            return new int[]{0, 0};
        }
        return new int[]{map.lastKey(), map.firstKey()};
    }
    
    private void removeValue(PriorityQueue<Integer> pq, TreeMap<Integer, Integer> map){
        int value;
        // 큐의 top 값이 맵에 없거나 카운트가 0이면(이미 다른 큐에서 삭제된 값)
        // 유효한 값이 나올 때까지 poll
        while(true){
            value = pq.poll();
            int count = map.getOrDefault(value, 0);
            
            if(count > 0){
                if(count == 1){
                    map.remove(value);
                }else{
                    map.put(value, count-1);
                }
                break;
            }
        }
    }
}