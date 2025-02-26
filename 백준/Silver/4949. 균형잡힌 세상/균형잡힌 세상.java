import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    while(!line.equals(".")){
      System.out.println(isBalanced(line) ? "yes" : "no");
      line = br.readLine();
    }
  }

  private static boolean isBalanced(String line) {
    Deque<Character> stack = new ArrayDeque<>();
    for(char c :  line.toCharArray()){
      if(c == '(' || c == '['){
        stack.push(c);
      }else if(c == ')' || c== ']'){
        if(stack.isEmpty()) return false;
        char e = stack.pop();
        if( e != '(' && c == ')'){
          return false;
        }
        if(e != '[' && c == ']') {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
