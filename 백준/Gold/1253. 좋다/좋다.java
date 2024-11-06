import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

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
        int left = 0; int right = arr.length-1;

        while(left < right){
            if(left == target_idx){
                left++;
                continue;
            }
            if(right == target_idx){
                right--;
                continue;
            }

            int currentSum = arr[left] + arr[right];

            if(currentSum == target) return true;
            if(currentSum > target){
                right--; continue;
            }
            left++;
        }

        return false;
    }
}
