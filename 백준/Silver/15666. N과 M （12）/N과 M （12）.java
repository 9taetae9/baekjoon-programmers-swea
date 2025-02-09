import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static List<Integer> list;
    static StringBuilder sb;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        N = set.size();


        list = new ArrayList<>(set);
        Collections.sort(list); //정렬된 상태 => 2 4

        sb = new StringBuilder();
        backtrack(0,0);

        System.out.println(sb);

    }

    private static void backtrack(int prev, int step) {
        if (step == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]);
                if(i!=M-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = prev; i < N; i++) {
            arr[step] = list.get(i);
            backtrack(i, step+1);
        }
    }
}
