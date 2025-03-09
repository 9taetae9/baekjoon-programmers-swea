class Solution {
    public int solution(int storey) {
        StringBuilder sb = new StringBuilder(Integer.toString(storey));
        int idx = 10;
        int sum =0;
        for(int i=sb.length()-1; i>=0; i--){
            int curLen = sb.length();
            int cur = sb.charAt(i)-'0';
            if( cur < 5){
                sum += cur; 
                storey /=idx;
                storey *= idx;
            
            }else if(cur == 5){
                sum += cur; 
                if(i==0) {
                    break;
                }
                //다음 자리 5이상 올림
                if(sb.charAt(i-1) >= '5'){
                    storey/=idx;
                    storey *= idx;
                    storey += idx;
                }else{//5 미만일때 내림
                    storey /=idx;
                    storey *= idx;
                }
            }else{
                sum += (10 - cur);
                storey /=idx;
                storey *= idx;
                storey += idx;
            }
            idx*=10;
            
            sb = new StringBuilder(Integer.toString(storey));
            if(curLen < sb.length()){
                i++;
            }
        }
        
        
        
        return sum;
    }
}

