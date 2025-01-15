import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String line = br.readLine();

            if(line.equals(".")){
                break;
            }

            line = line.trim();

            System.out.println(isBalanced(line) ? "yes" : "no");
        }
    }

    private static boolean isBalanced(String line){
        Stack<Character> stack = new Stack<>();
        for(char c : line.toCharArray()){
            if(c == '(' || c =='['){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }else if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}