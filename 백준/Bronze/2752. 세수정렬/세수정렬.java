import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc =new Scanner(System.in);
    	int[] threenums = new int[3];
    	threenums[0]=sc.nextInt();
    	threenums[1]=sc.nextInt();
    	threenums[2]=sc.nextInt();
    	
    	Arrays.sort(threenums);
    	
    	Arrays.stream(threenums).forEach(num->System.out.print(num+" "));
    }
}
