class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int cnt = 0;
        for(int a=1; a<=n; a++){
            for(int b=a+1; b<=n; b++){
                for(int c=b+1; c<=n; c++){
                    for(int d=c+1; d<=n; d++){
                        for(int e=d+1; e<=n; e++){
                            //해당 조합이 시도와 매칭되는지 확인
                            if(isMatch(new int[]{a,b,c,d,e}, q, ans)){
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
        
        return cnt;
    }
    
    private boolean isMatch(int[] password, int[][] attempt, int[] ans){
        
        for(int i=0; i < ans.length; i++){
            int correctCnt = getCorrectCount(password, attempt[i]);
            if(ans[i] != correctCnt) return false;
        }
        
        return true;
    }
    
    private int getCorrectCount(int[] password, int[] attempt){
        int cnt = 0;
        int p1 = 0, p2 = 0;
        
        while(p1 < 5 && p2 < 5){
            if(password[p1] == attempt[p2]) {
                cnt++;
                p1++; p2++;
            }else if(password[p1] > attempt[p2]){
                p2++;
            }else{
                p1++;
            }
        }
        
        return cnt;
    }
    
}

/**
각 추축에서 가능한 조각들을 찾기 x
가능한 비밀번호 조합을 매칭 시켜보기
*/