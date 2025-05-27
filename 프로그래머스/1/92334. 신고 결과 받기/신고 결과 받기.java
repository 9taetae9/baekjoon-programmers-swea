import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> userIdx = new HashMap<>();
        Map<String, Set<String>> reportedUser = new HashMap<>();
        Map<String, Integer> mailCount = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            userIdx.put(id_list[i], i);
        }
        
        for(String r : report){
            String[] part = r.split(" ");
            if(!reportedUser.containsKey(part[1])){
                reportedUser.put(part[1], new HashSet<>());
            }
            
            reportedUser.get(part[1]).add(part[0]);
        }
        
        
        
        for(Set<String> mailSet: reportedUser.values()){
            if(mailSet.size() >= k){
                for(String reporter : mailSet){
                    mailCount.merge(reporter, 1, Integer::sum);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for(Map.Entry<String,Integer> m : mailCount.entrySet()){
            answer[userIdx.get(m.getKey())] = m.getValue();
        }
        return answer;
    }
}