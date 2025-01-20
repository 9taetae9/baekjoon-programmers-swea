import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static final List<Integer> AllNumbers =
            IntStream.rangeClosed(1,20)
                    .boxed()
                    .collect(Collectors.toList());

    public static void main(String[] args) throws IOException {
        Set<Integer> S = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");
            if(query[0].equals("all")){
                S.addAll(AllNumbers);
                continue;
            }
            if(query[0].equals("empty")){
                S.clear();
                continue;
            }

            Integer n = Integer.parseInt(query[1]);
            
            switch (query[0]){
                case "add":
                    S.add(n);
                    break;
                case "remove":
                    S.remove(n);
                    break;
                case "check" :
                    sb.append(S.contains(n) ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    if(S.contains(n)){
                        S.remove(n);
                    }else S.add(n);
                    break;
            }
        }
        System.out.println(sb);
    }
}