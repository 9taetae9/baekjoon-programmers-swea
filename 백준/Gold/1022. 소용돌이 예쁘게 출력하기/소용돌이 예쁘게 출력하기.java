import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int maxLen = 1;
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                maxLen = Math.max(maxLen, String.valueOf(getValue(i,j)).length());
            }
        }

        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                System.out.printf("%"+maxLen+"d", getValue(i,j));
                if(j!=c2) System.out.print(" ");
            }
            System.out.println();
        }

    }

    private static int getValue(int y, int x){
        int layer = Math.max(Math.abs(y), Math.abs(x));
        int startVal = (2*layer-1)*(2*layer-1);
        int sideLength = 2*layer;

        if(Math.abs(x) == Math.abs(y)){
            if( x > 0 && y < 0) return startVal + sideLength;
            if( x < 0 && y < 0) return startVal + sideLength*2;
            if( x < 0 && y > 0) return startVal + sideLength*3;
            return startVal + sideLength*4;
        }

        if(x == layer) return startVal + (layer - y);
        if(y == -layer) return startVal + sideLength + (layer - x);
        if(x == -layer) return startVal + sideLength * 2 + (y + layer);
        return startVal + sideLength * 3 + (x + layer);
    }
}