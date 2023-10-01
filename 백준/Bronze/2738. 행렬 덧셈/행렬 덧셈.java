import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        int[] A= new int[row*col];
        
        for(int i=0; i<row*col; i++) {
        	A[i]=sc.nextInt();
        }
        for(int i=0; i<row*col; i++) {
        	A[i]+=sc.nextInt();
        }
        for(int i=0; i<row*col; i++) {
        	System.out.print(A[i]+" ");
        	if(i%col==col-1) System.out.println();
        }

        
        sc.close();
    }
}

