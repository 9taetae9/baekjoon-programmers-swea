import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idToName = new HashMap<>();
        
        int len = 0;
        for(String log : record){
            String[] part = log.split(" ");
            if(part.length == 3){
                idToName.put(part[1],part[2]);
            }
            if(part[0].equals("Enter") || part[0].equals("Leave")) len++;
        }
        
        String[] answer = new String[len];
        int idx = 0;
        for(int i=0; i<record.length; i++){
            String[] part = record[i].split(" ");
            if(part[0].equals("Enter")){
                answer[idx++] = idToName.get(part[1])+"님이 들어왔습니다.";
            }else if(part[0].equals("Leave")){
                answer[idx++] = idToName.get(part[1])+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}