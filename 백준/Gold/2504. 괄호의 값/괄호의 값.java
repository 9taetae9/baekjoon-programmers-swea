import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<String> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            if(c == '('|| c == '['){
                stack.push(String.valueOf(c));
            }else{
                int sum = 0;
                if(stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                String p = stack.pop();
                if(c == ')'){
                    while(!p.equals("(")){
                        if(p.equals("[")){
                            System.out.println(0);
                            return;
                        }
                        sum += Integer.parseInt(p);
                        if(stack.isEmpty()) {
                            System.out.println(0);
                            return;
                        }
                        p = stack.pop();
                    }
                    if(sum == 0) sum = 2;
                    else sum*=2;
                }else{
                    while(!p.equals("[")){
                        if(p.equals("(")){
                            System.out.println(0);
                            return;
                        }
                        sum += Integer.parseInt(p);
                        if(stack.isEmpty()) {
                            System.out.println(0);
                            return;
                        }
                        p = stack.pop();
                    }
                    if(sum == 0) sum = 3;
                    else sum*=3;
                }
                stack.push(String.valueOf(sum));
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek().equals("(") || stack.peek().equals("[")) {
                System.out.println(0);
                return;
            }
            result += Integer.parseInt(stack.pop());
        }

        System.out.println(result);
    }
}
