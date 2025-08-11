import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = toSec(play_time);
        int advSec = toSec(adv_time);
        
        long[] changes = new long[playSec + 1];
        
        for(String log : logs){
            String[] parts = log.split("-");
            int start = toSec(parts[0]);
            int end = toSec(parts[1]);
            changes[start]++;
            changes[end]--;
        }
        
        // 시청자 수(초 구간)
        long[] viewers = new long[playSec];
        long cur = 0;
        for(int i=0; i < playSec; i++){
            cur += changes[i];
            viewers[i] = cur;
        }
        
        // 누적 시청자 수
        long[] prefix = new long[playSec];
        if(playSec > 0){
            prefix[0] = viewers[0];
            for(int i=1; i<playSec; i++){
                prefix[i] = prefix[i-1] + viewers[i];
            }
        }
        
        int initEnd = advSec - 1;
        long bestSum = prefix[initEnd];
        int bestStart = 0;
        
        for(int s=1; s + advSec - 1 < playSec; s++){
            int e = s + advSec - 1;
            long sum = prefix[e] - prefix[s-1];
            if(sum > bestSum){
                bestSum = sum;
                bestStart = s;
            }
        }

        return toTimeStr(bestStart);
    }
    
    private int toSec(String time){
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        int sec = Integer.parseInt(parts[2]);
        
        return hour*3600 + min*60 + sec;
    }
    
    private String toTimeStr(int sec){
        int hour = sec / 3600;
        sec %= 3600;
        int min = sec / 60;
        sec %= 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
    
    
}