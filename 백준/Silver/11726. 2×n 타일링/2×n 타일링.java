import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int a = 1;
    int b = 1;
    for (int i = 1; i < n; i++) {
      int temp = a % 10007;
      a = b % 10007;
      b = (temp + b)%10007;
    }

    System.out.println(b);
  }

}
