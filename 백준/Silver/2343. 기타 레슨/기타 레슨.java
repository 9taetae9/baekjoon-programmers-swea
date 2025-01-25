import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        첫째 줄에 강의의 수 N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)이 주어진다. => 10만? 이분 탐색
//        다음 줄에는 강토의 기타 강의의 길이가 강의 순서대로 분 단위로(자연수)로 주어진다. 각 강의의 길이는 10,000분을 넘지 않는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 타겟

        st = new StringTokenizer(br.readLine());
        int[] lesson = new int[N];
        int max = 0;
        int min = 0;
        for(int i=0; i<N; i++){
            int e = Integer.parseInt(st.nextToken());
            max += e;
            min = Math.max(min, e);
            lesson[i] = e;
        }


        while(min <= max){
            int mid = (min + max) / 2;
            int p = numsOfPartition(mid, lesson);
            if(M >= p){
                max = mid-1;
            }else {
                min = mid+1;
            }
        }


        System.out.println(min);
    }

    private static int numsOfPartition(int mid, int[] lesson){
        int num = 1;
        int sum = 0;

        for(int i=0; i<lesson.length; i++){
            if(sum + lesson[i]> mid){
                num++;
                sum=lesson[i];
            }else{
                sum+=lesson[i];
            }
        }

        return num;
    }
}
