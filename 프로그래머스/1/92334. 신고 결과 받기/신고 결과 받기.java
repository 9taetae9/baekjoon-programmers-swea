import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> userIdx = new HashMap<>();
        Map<String, Integer> userToReport = new HashMap<>();
        Set<String> reportSet = new HashSet<>(); //muzi frodo
        Map<String, List<String>> reportPeople = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            userIdx.put(id_list[i], i);
        }
        
        for(String r : report){
            if(!reportSet.contains(r)){
                reportSet.add(r);
                String[] part = r.split(" ");
                if(!reportPeople.containsKey(part[1])){
                    reportPeople.put(part[1], new ArrayList<>());
                }
                reportPeople.get(part[1]).add(part[0]);
                
                userToReport.merge(part[1], 1, Integer::sum);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(Map.Entry<String, Integer> userReport : userToReport.entrySet()){
            if(userReport.getValue() >= k){
                String key = userReport.getKey(); //frodo : 2 frodo 추출 
                //신고했던 사람들
                for(String p : reportPeople.get(key)){
                    answer[userIdx.get(p)]++;
                }
            }
        }
        
        return answer;
    }
}