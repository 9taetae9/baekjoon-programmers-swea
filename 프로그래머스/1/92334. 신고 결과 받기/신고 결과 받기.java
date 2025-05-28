import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedUser = new HashMap<>();
        Map<String, Integer> userReports = new HashMap<>();
        
        for(String r : report){
            String[] part = r.split(" ");
            String reporter = part[0];
            String reported = part[1];
            
            if(!reportedUser.containsKey(reported)){
                reportedUser.put(reported, new HashSet<>());
            }
            
            reportedUser.get(reported).add(reporter);
        }
        
        for(Set<String> set : reportedUser.values()){
            if(set.size() >= k){
                for(String reporter : set){
                    userReports.merge(reporter, 1, Integer::sum);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            
            answer[i] = userReports.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}