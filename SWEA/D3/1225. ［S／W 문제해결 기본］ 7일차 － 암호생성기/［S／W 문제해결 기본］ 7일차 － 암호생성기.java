import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10; // 10개의 테스트 케이스

        for (int test_case = 1; test_case <= T; test_case++) {
            br.readLine(); // 테스트 케이스 번호 (사용하지 않음)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] numbers = new int[8];
            
            // 8개의 숫자 입력 받기
            for (int i = 0; i < 8; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            boolean finished = false;

            while (!finished) {
                for (int i = 1; i <= 5; i++) {
                    int temp = numbers[0] - i;
                    if (temp <= 0) {
                        temp = 0;
                        finished = true;
                    }
                    
                    // 배열 요소 이동
                    System.arraycopy(numbers, 1, numbers, 0, 7);
                    numbers[7] = temp;

                    if (finished) break;
                }
            }

            // 결과 저장
            sb.append("#").append(test_case);
            for (int num : numbers) {
                sb.append(" ").append(num);
            }
            sb.append("\n");
        }
        
        // 전체 결과 한 번에 출력
        System.out.print(sb);
        br.close();
    }
}