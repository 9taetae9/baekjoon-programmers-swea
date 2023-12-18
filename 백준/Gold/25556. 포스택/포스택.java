import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        ArrayList<Integer> numlist = new ArrayList<>();

        for(int i=0; i<N; i++){
            numlist.add(sc.nextInt());
        }

        ArrayList<Stack<Integer>> stackList = new ArrayList<>();
        for(int i=0; i<4; i++) {
            stackList.add(new Stack<>());
            stackList.get(i).add(Integer.MIN_VALUE);
        }

        boolean cleanFlag = true;
        for(int num : numlist){
            if(!placeInStack(num, stackList)){
                cleanFlag = false;
                break;
            }
        }

        System.out.println(cleanFlag ? "YES" : "NO");
    }

    public static boolean placeInStack(int num, ArrayList<Stack<Integer>> stackList){
        for(Stack<Integer> stack : stackList){
            if(num > stack.peek()) {
                stack.push(num);
                return true;
            }
        }
        return false;
    }
}