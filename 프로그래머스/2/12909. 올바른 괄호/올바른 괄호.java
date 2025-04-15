class Solution {
    boolean solution(String s) {
        int n = 0;
        for(char c : s.toCharArray()){
            if(c == '(') n++;
            else n--;
            
            if(n < 0) return false;
        }
        
        return n == 0;
        
    }
}