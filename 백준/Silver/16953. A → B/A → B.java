import java.util.*;

public class Main{
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        optimalCount(A, B, 0);
        if(min == Long.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    private static void optimalCount(long A, long B, long cnt){
        if(A > B) return ;
        if(A == B){
            min = Math.min(min, cnt+1);
            return ;
        }

        optimalCount(A * 2, B, cnt+1);
        optimalCount(Long.parseLong(Long.toString(A)+"1"), B, cnt+1);
    }
}