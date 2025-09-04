import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                for(int r2=r; r2<N; r2++){
                    for(int c2=c; c2<N; c2++){
                        if(isValid(r,c,r2,c2)){
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);

    }

    private static boolean isValid(int r, int c, int r2, int c2){
        // 일단 해당 구간 수들 리스트에 넣기
        List<Integer> numbers = new ArrayList<>();

        for(int i=r; i<=r2; i++){
            for(int j=c; j<=c2; j++){
                numbers.add(board[i][j]);
            }
        }

        Collections.sort(numbers);

        for(int i=1; i <= numbers.size(); i++){
            if(numbers.get(i-1) != i) return false;
        }

        return true;
    }
}