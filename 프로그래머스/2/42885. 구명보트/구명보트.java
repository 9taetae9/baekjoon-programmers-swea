import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        int sum = people[right];
        int cnt = 0;
        while(left < right){
            if(sum + people[left] <= limit){
                sum = sum + people[left];
                left++;
                right--;
                sum = people[right];
                cnt++;
            }else{
                right--;
                sum = people[right];
                cnt++;
            }
        }
        
        
        return (left==right) ? cnt+1 : cnt;
    }
}