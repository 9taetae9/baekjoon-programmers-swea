import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int maxIndex = i;
            for(int j=i+1; j<N && j-i<=S; j++){
                if(list.get(maxIndex) < list.get(j)){
                    maxIndex = j;
                }
            }

            for(int j=maxIndex; j>i; j--){
                Collections.swap(list, j, j-1);
            }

            S -= (maxIndex - i);
        }

        for(int e : list){
            System.out.print(e+" ");
        }
    }
}
