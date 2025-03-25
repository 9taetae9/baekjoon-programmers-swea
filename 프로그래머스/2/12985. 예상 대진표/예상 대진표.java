class Solution
{
    public int solution(int n, int a, int b)
    {
        return getRound(a < b ? a : b, a >= b ? a : b);
    }
    
    private int getRound(int a, int b){
        int r = 1;
        while(!(b-a == 1 && a % 2 == 1)){
            if(a %2 == 0){
                a/=2;
            }else{
                a++;
                a/=2;
            }
            if(b%2 == 0){
                b/=2;
            }else{
                b++;
                b/=2;
            }
            r++;
        }
        
        
        return r;
    }
}