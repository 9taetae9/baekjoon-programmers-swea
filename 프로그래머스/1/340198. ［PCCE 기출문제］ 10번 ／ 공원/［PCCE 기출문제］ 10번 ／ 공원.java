import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        for(int i = mats.length - 1; i >=0; i--){
            for(int x = 0; x < park.length; x++){
                for(int y = 0; y < park[0].length; y++){
                    if(isEmpty(x,y,mats[i],park)) return mats[i];
                }
            }
        }
        
        
        return -1;
    }
    
    private boolean isEmpty(int startX, int startY, int len, String[][] park){
        if(startX + len > park.length) return false;
        if(startY + len > park[0].length) return false;
        
        for(int i=startX; i < startX+len; i++){
            for(int j=startY; j<startY+len; j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
}

/*
mats = 돗자리 한변의 길이
자리 배치도 = 빈자리 => -1
*/