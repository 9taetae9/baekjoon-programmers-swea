import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static char[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    arr = new char[N][M];

    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine().toCharArray();
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        min = Math.min(min, check(i, j));
      }
    }

    System.out.println(min);
  }

  private static int check(int x, int y){
    int cntB = 0, cntW = 0;

    for (int i = x; i < x + 8; i++) {
      for (int j = y; j < y + 8; j++) {
        if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
          if(arr[i][j] == 'B') cntB++;
        }else if(arr[i][j] == 'W') cntW++;
      }
    }
    int total = cntB + cntW;

    return total > 32 ? 64 - total : total;
  }


}
