import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int t = Integer.parseInt( br.readLine());
            List<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            
            int num = 0;
            while (list.get(7) > 0) {
                int value = list.remove(0) - (num % 5 + 1);
                list.add(value > 0 ? value : 0);
                num++;
            }
            
            System.out.print("#" + t + " ");
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}