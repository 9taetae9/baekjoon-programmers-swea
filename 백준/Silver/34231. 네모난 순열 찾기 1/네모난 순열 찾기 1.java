import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalCount = 0;
        // 시작 행, 끝 행 고정
        for(int r1=0; r1<N; r1++){
            for(int r2=r1; r2<N; r2++){
                //시작 열 고정
                for(int c1=0; c1<N; c1++){
                    // 순열 판별을 위한 자료구조 초기화
                    boolean[] visited = new boolean[N*N + 1];
                    int maxVal = 0;
                    int elementCount = 0;
                    boolean hasDuplicate = false;
                    // 끝 열 확장
                    for(int c2 = c1; c2 < N; c2++){
                        //새로 추가되는 c2열의 원소들만 업데이트
                        for(int r = r1; r <= r2; r++){
                            int num = board[r][c2];
                            elementCount++;
                            maxVal = Math.max(maxVal, num);

                            if(visited[num]){
                                hasDuplicate = true;
                                break;
                            }
                            visited[num] = true;
                        }

                        if(hasDuplicate){
                            break;
                        }

                        if(elementCount == maxVal){
                            totalCount++;
                        }
                    }

                }
            }
        }


        System.out.println(totalCount);

    }
    
}