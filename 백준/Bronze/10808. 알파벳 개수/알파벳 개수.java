import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int[] cnt=new int[26];
        for(int i=0; i<s.length(); i++) {
        	cnt[s.charAt(i)-97]++;
        }
        Arrays.stream(cnt).forEach(e->System.out.print(e+" "));
    }
}
