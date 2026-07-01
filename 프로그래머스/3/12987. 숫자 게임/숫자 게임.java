import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0;
        int b = 0;
        
        while(a < A.length && b < B.length){
            if(A[a] < B[b]){
                answer++;
                a++;
            }
            b++;
        }
        
        return answer;
    }
}

/**
1 3 5 7
2 2 6 8
*/