import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int[][] arr = new int[5][5];
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, int[]> map = new HashMap<>();

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        int num = Integer.parseInt(st.nextToken());
        map.put(num, new int[]{i,j});
        arr[i][j] = num;
      }
    }

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        int num = Integer.parseInt(st.nextToken());
        int[] idx = map.get(num);
        arr[idx[0]][idx[1]] = 0;
        if (countBingo(arr) >= 3) {
          System.out.println(i*5 + j+1);
          return;
        }
      }
    }
  }

  private static int countBingo(int[][] arr) {
    int cnt = 0;

    //행
    for (int i = 0; i < 5; i++) {
      boolean bingo = true;
      for (int j = 0; j < 5; j++) {
        if (arr[i][j] != 0) {
          bingo = false;
          break;
        }
      }
      if(bingo) cnt++;
    }

    //열
    for (int j = 0; j < 5; j++) {
      boolean bingo = true;
      for (int i = 0; i < 5; i++) {
        if (arr[i][j] != 0) {
          bingo = false;
          break;
        }
      }
      if(bingo) cnt++;
    }

    //대각선
    boolean bingo = true;
    for (int i = 0; i < 5; i++) {
      if (arr[i][i] != 0) {
        bingo = false;
        break;
      }
    }
    if(bingo) cnt++;

    bingo = true;
    for (int i = 0; i < 5; i++) {
      if (arr[i][4 - i] != 0) {
        bingo = false;
        break;
      }
    }
    if(bingo) cnt++;

    return cnt;
  }
}
