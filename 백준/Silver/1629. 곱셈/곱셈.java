import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        long A = Long.parseLong(inputs[0]);
        long B = Long.parseLong(inputs[1]);
        long C = Long.parseLong(inputs[2]);

        long result = 1;
        A%=C;
        
        while(B>0){
            if(B%2==1){
                result = (result*A)%C;
            }
            A = (A*A)%C;
            B/=2;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}