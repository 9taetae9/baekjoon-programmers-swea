import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        int[] arr = new int[strArr.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        Arrays.sort(arr);
        
        String ans = arr[0] + " " + arr[arr.length - 1];
        return ans;
    }
}