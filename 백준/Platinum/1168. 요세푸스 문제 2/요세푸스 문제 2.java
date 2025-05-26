import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] tree; //세그먼트 트리
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1~N번
        int K = Integer.parseInt(st.nextToken()); // K번째 제거

        tree = new int[4*N];
        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int pos = 0; // 현재 위치

        for (int i = 0; i < N; i++) {
            int remain = N - i; // 남은 사람 수

            //다음 제거할 사람의 위치 계산
            //(현재 위치 + K - 1) % 남은 사람 수
            pos = (pos + K - 1) % remain;

            //pos 번째 사람 찾기(1-indexed로 변환)
            int removed = query(1, 1, N, pos + 1);

            update(1, 1, N, removed);

            if (i == N - 1) {
                sb.append(removed).append(">");
            } else {
                sb.append(removed).append(", ");
            }
        }

        System.out.println(sb);
    }



    //세그먼트 트리 초기화, 각 구간의 크기만큼 저장
    private static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = 1;
        }

        int mid = (start + end) / 2;
        return tree[node] = init(2 * node, start, mid) +
                        init(2*node+1, mid+1, end);
    }

    private static int query(int node, int start, int end, int k) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;
        int leftCount = tree[2 * node]; // 왼쪽 서브트리에 있는 사람 수

        // k번째가 왼쪽 서브트리에 있는 경우
        if (k <= leftCount) {
            return query(2 * node, start, mid, k);
        } else { // k번째가 오른쪽 서브트리에 있는 경우
            return query(2 * node + 1, mid + 1, end, k - leftCount);
        }
    }

    private static void update(int node, int start, int end, int idx) {
        if (start == end) {
            tree[node] = 0; // 제거
            return;
        }

        int mid = (start+ end)/2;

        if (idx <= mid) {
            update(2 * node, start, mid, idx);
        } else {
            update(2 * node + 1, mid + 1, end, idx);
        }

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

}
