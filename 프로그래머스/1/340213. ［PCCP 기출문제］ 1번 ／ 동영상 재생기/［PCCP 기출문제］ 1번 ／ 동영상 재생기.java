class Solution {
    private int timeToSeconds(String time){
        String[] part = time.split(":");
        int min = Integer.parseInt(part[0]);
        int second = Integer.parseInt(part[1]);
        
        return min * 60 + second;
    }
    
    private String secondsToTime(int totalSeconds){
        int minutes = totalSeconds/60;
        int seconds = totalSeconds%60;
        
        return String.format("%02d:%02d", minutes, seconds);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //시간문자열 => 초단위
        int videoLen = timeToSeconds(video_len);
        int currentPos = timeToSeconds(pos);
        int opStart = timeToSeconds(op_start);
        int opEnd = timeToSeconds(op_end);
        
        if(currentPos >= opStart && currentPos < opEnd){
            currentPos = opEnd;
        }
        
        for(String command : commands){
            if(command.equals("prev")){
                if(currentPos < 10){
                    currentPos = 0;
                }else{
                    currentPos -= 10;
                }
            }else if(command.equals("next")){
                if(currentPos + 10 > videoLen){
                    currentPos = videoLen;
                }else{
                    currentPos += 10;
                }
            }
            
            
            if(currentPos >= opStart && currentPos < opEnd){
                currentPos = opEnd;
            }
        }
        
        return secondsToTime(currentPos);
        
    }
}