class Solution {
    static int ans = 0;
    static char[] chars;
    public int solution(String s) {
        chars = s.toCharArray();
        int start = 0;
        while(start < chars.length){
            char x = chars[start];
            start = nextIndex(x, start);
        }
        return ans;
    }
    
    private int nextIndex(char x, int start){
        int num = 0;
        for(int i = start; i < chars.length; i++){
            if(chars[i] == x) num++;
            else num--;
            
            if(num == 0) {
                ans++;
                return i+1;
            }
        }
        ans++;
        return chars.length;
    }
}