import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] submit= new int[31];
        for(int i=0; i<28; i++) {
        	int num=sc.nextInt();
        	submit[num]++;
        }
        for(int i=1; i<31; i++) {
        	if(submit[i]==0) {
        		System.out.println(i);
        	}
        }
        sc.close();
    }
}
