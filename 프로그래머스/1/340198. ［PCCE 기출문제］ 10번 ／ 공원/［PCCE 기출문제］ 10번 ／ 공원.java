import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        for(int i = mats.length - 1; i >=0; i--){
            int L = mats[i];
            for(int x = 0; x <= park.length - L ; x++){
                for(int y = 0; y <= park[0].length - L; y++){
                    if(isEmpty(x,y,L,park)) return L;
                }
            }
        }
        

        return -1;
    }

    private boolean isEmpty(int startX, int startY, int len, String[][] park){
        // if(startX + len > park.length) return false;
        // if(startY + len > park[0].length) return false;

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