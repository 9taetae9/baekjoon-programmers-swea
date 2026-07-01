class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1) return arr[0];
        
        int answer = lcm(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    private static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}