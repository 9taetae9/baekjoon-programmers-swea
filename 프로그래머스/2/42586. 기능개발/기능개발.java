import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        if(progresses.length == 1){
            return new int[]{1};
        }

        int len = speeds.length;
        
        int[] daysNeed = new int[len];
        
        for(int i=0; i < len; i++){
            int remain = 100 - progresses[i];
            int days = remain / speeds[i];
            if(remain % speeds[i] != 0) days++;
            daysNeed[i] = days;
        }
        
        for(int i=1; i< len; i++){
            if(daysNeed[i-1] >= daysNeed[i]){
                daysNeed[i] = daysNeed[i-1];
            }
        }
        
        List<Integer> dayList= new ArrayList<>();
    
        int prevDay = daysNeed[0];
        int cnt = 1;
        for(int i=1; i<len; i++){
            if(prevDay != daysNeed[i]){
                dayList.add(cnt);
                prevDay = daysNeed[i];
                cnt = 1;
            }else{
                cnt++;
            }
        }
        dayList.add(cnt);
        
        
        int[] answer = new int[dayList.size()];
        for(int i=0; i < dayList.size(); i++){
            answer[i] = dayList.get(i);
        }
        return answer;
    }
}


//5 10 1 1 20 1
//5 10 10 10 20 20
//1 3 2