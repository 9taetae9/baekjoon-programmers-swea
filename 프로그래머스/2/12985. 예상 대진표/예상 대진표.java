class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int small,big;
        
        if(a>b){
            big = a-1;
            small = b-1; 
        }else{
            big = b-1;
            small = a-1;
        }
        
        while(true){
            if(big - small == 1 && small % 2 == 0) break;
            small/=2;
            big/=2;
            n/=2;
            answer++;
        }
        
        return answer;
    }
}

/*
1,2 3,4, 5,6, 7,8
1, 2, 3, 4

0, 1, 2, 3, 4, 5, 6, 7
0, 1, 2, 3 
0, 1


3 -> 1 -> 0
6 -> 3 -> 1
*/