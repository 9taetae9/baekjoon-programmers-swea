import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());


        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            if(x == 0){
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
            else queue.add(x);
        }
    }
}