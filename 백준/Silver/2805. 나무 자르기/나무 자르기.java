import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static long[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=  new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 나무 수
    long target = Integer.parseInt(st.nextToken());

    arr = new long[N];
    st=  new StringTokenizer(br.readLine());

    long low =0;
    long high =0;
    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
      high = Math.max(arr[i], high);
    }

    long maxHeight = 0;
    while(low <= high){
      long mid = low + (high - low)/2;
      long num = getTree(mid);
      if(target > num){
        high = mid-1;
      }else{
        maxHeight = Math.max(maxHeight, mid);
        low = mid +1;
      }
    }

    System.out.println(maxHeight);

  }

  private static long getTree(long height){
    long sum = 0;
    for(long e : arr){
      sum += Math.max((e - height), 0);
    }

    return sum;
  }
}
