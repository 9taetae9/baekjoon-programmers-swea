import java.util.*;
class Solution {
    int[] arr1 = new int[]{1,2,3,4,5};
    int[] arr2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    int[] arr3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int len1 = arr1.length;
    int len2 = arr2.length;
    int len3 = arr3.length;
    
    int s1,s2,s3;
    
    public int[] solution(int[] answers) {
        
        for(int i=0; i<answers.length; i++){
            if(arr1[i%len1] == answers[i]) s1++;
            if(arr2[i%len2] == answers[i]) s2++;
            if(arr3[i%len3] == answers[i]) s3++;
        }
        
        int max = Math.max(s1,Math.max(s2,s3));
        
        List<Integer> ans = new ArrayList<>();
        if(s1 == max){
            ans.add(1);
        }
       if(s2 == max){
            ans.add(2);
        }
        if(s3 == max){
            ans.add(3);
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}