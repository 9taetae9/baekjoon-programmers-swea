import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int target = sc.nextInt();

       int[] arr = new int[N+1];
       int[] presum = new int[N+1];

       int cnt = 0;
       for(int i=1; i<=N; i++){
           arr[i] = sc.nextInt();
           presum[i] = arr[i] + presum[i-1];
       }


       for(int i=0; i<N; i++){
           for(int j=i+1; j<=N; j++){
               if(presum[j]-presum[i] == target) {
                   //System.out.println(i+"번째 ~ "+(j-1)+"번째");
                   cnt++;
               }
           }
       }

//       System.out.println("arr : ");
//       for(int e : arr){
//           System.out.print(e+" ");
//       }
//       System.out.println();
//
//       System.out.println("presum : ");
//       for(int e : presum){
//           System.out.print(e+" ");
//       }

       //System.out.println();
       System.out.println(cnt);
    }

}