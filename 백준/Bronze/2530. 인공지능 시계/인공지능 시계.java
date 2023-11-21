import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int hour = sc.nextInt();
    	int minute = sc.nextInt();
    	int second = sc.nextInt();
    	
    	int e_sec = sc.nextInt();
    	
    	second += e_sec%60;
    	minute += e_sec/60;
    	
    	if(second>59) {
    		minute++;
    		second%=60;
    	}
    	
    	hour+= minute/60;
    	minute %=60;
    	
    	hour%=24;
    	
    	System.out.print(hour+" "+minute+" "+second);
    }
}
