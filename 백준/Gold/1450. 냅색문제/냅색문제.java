import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static long C;
    static long[] weights;
    static List<Long> sumsA = new ArrayList<>();
    static List<Long> sumsB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        weights = new long[N];
    
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            weights[i] = Long.parseLong(st.nextToken());
        }

        int mid = N/2;
        generateSums(0, mid, 0L, sumsA);
        generateSums(mid, N, 0L, sumsB);

        Collections.sort(sumsB);


        long count = 0;
        for(long sumA : sumsA){
            long rem  = C - sumA;
            
            if(rem < 0) continue;

            count += upperBound(sumsB, rem);
        }

        System.out.println(count);
    }

//재귀적으로 모든 부분집합 합 구하기 weights[l..r-1]
    static void generateSums(int l, int r, long currSum, List<Long> list){
        if(l == r){
            list.add(currSum);
            return;
        }

        generateSums(l+1, r, currSum, list);
        generateSums(l+1, r, currSum + weights[l], list);
    }

    static int upperBound(List<Long> list, long key){
        int lo = 0, hi = list.size();
        while(lo < hi){
            int mid = (lo + hi) >>> 1;
            if(list.get(mid) <= key) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}