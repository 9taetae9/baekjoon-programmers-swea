import java.io.*;
import java.util.*;

public class Main {
    static int N; // 책 개수
    static int M; // 한 번에 옮길 수 있는 최대 책 개수
    static int[] books;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        books = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(books);

        System.out.println(findMinimumSteps());
    }

    private static int findMinimumSteps() {
        int totalSteps = 0;

        int lastNegativeIndex = 0;
        while (lastNegativeIndex < N && books[lastNegativeIndex] < 0) {
            lastNegativeIndex++;
        }

        // 가장 먼 위치 확인
        int farthest = 0;
        if (lastNegativeIndex > 0 && lastNegativeIndex < N) {
            farthest = Math.max(Math.abs(books[0]), Math.abs(books[N - 1]));
        } else if (lastNegativeIndex == 0) { // 양수만 있을 때
            farthest = Math.abs(books[N - 1]);
        } else { // 음수만 있을 때
            farthest = Math.abs(books[0]);
        }

        // 음수 (0 ~ lastNegativeIndex 미만)
        for (int i = 0; i < lastNegativeIndex; i += M) { //M개 단위로 옮기기
            // 가장 먼 음수 위치 편도 처리, 나머지는 왕복
            if (Math.abs(books[i]) == farthest) {
                totalSteps += Math.abs(books[i]);
            } else {
                totalSteps += Math.abs(books[i]) * 2;
            }
        }

        // 양수 (lastNegativeIndex ~ 끝)
        for (int i = N - 1; i >= lastNegativeIndex; i -= M) {
            // 가장 먼 양수 위치 편도 처리, 나머지는 왕복
            if (books[i] == farthest) {
                totalSteps += books[i];
            } else {
                totalSteps += books[i] * 2;
            }
        }

        return totalSteps;
    }
}
