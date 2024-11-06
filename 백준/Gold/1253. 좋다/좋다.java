import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(isGoodNumber(arr[i], i))
                count++;
        }

        System.out.println(count);
    }


    private static boolean isGoodNumber(int target, int target_idx){
        int left = 0; int right = N-1;

        while(left < right){
            int currentSum = arr[left] + arr[right];

            if(currentSum > target){
                right--;
            }else if(currentSum < target){
                left++;
            }else{
                if(left == target_idx) left++;
                else if(right == target_idx) right--;
                else return true;
            }
        }
        return false;
    }
}
