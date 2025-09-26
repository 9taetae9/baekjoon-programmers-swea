import java.util.*;

class Solution {
    char[] arr;
    boolean[] used;
    Set<Integer> nums;
    int len;
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        nums = new HashSet<>();
        len = numbers.length();
        used = new boolean[len];
        
        getAllComb(new StringBuilder());
        
        int cnt = 0;
        for(int k : nums){
            if(isPrime(k)){
                cnt++;
            }
        }
        return cnt;
    }
    
    private void getAllComb(StringBuilder curr){
        if(curr.length() != 0 && curr.length() <= len){
            int a = Integer.parseInt(curr.toString());
            nums.add(a);
        }
   
        for(int i=0; i<len; i++){
            if(!used[i]){
                used[i] = true;
                getAllComb(curr.append(arr[i]));
                curr.setLength(curr.length()-1);
                used[i] = false;
            }
        }     
    }
    
    private boolean isPrime(int n){
        if(n <= 1) return false;
        if(n <= 3) return true;
        
        if(n % 2 == 0 || n % 3 == 0) return false;
        
        for(int i = 5; i*i <= n; i+=6){
            if(n % i == 0 || n % (i+2) == 0) return false;
        }
        
        return true;
    }
}