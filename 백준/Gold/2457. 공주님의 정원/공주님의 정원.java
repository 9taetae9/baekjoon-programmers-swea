import java.util.*;
import java.io.*;

public class Main {

    static class Flower implements Comparable<Flower>{
        int[] start = new int[2];
        int[] end = new int[2];

        public Flower(int start_m, int start_d, int end_m, int end_d){
            this.start[0] = start_m;
            this.start[1] = start_d;
            this.end[0] = end_m;
            this.end[1] = end_d;
        }

        //시작일 기준
        @Override
        public int compareTo(Flower other){
            if(this.start[0] != other.start[0]){
                return Integer.compare(this.start[0], other.start[0]);
            }else if(this.start[1]!=other.start[1]){
                return Integer.compare(this.start[1], other.start[1]);
            }else if(this.end[0]!=other.end[0]){
                return Integer.compare(other.end[0], this.end[0]);
            }else{
                return Integer.compare(other.end[1], this.end[1]);
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Flower> flowers = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start_m = Integer.parseInt(st.nextToken());
            int start_d = Integer.parseInt(st.nextToken());
            int end_m = Integer.parseInt(st.nextToken());
            int end_d = Integer.parseInt(st.nextToken());
            flowers.add(new Flower(start_m,start_d, end_m, end_d));
        }

        Collections.sort(flowers);

        int count = 0;
        int index = 0;
        int currentMonth = 3;
        int currentDay = 1;


        while (currentMonth < 12) {
            int maxEndMonth = currentMonth;
            int maxEndDay = currentDay;
            boolean found = false;

            while(index < flowers.size() &&
                    (flowers.get(index).start[0] < currentMonth ||
                    (flowers.get(index).start[0] == currentMonth &&
                           flowers.get(index).start[1] <= currentDay))){

                Flower current = flowers.get(index);
                //더 늦으면 갱신
                if(isLaterDate(current.end[0], current.end[1], maxEndMonth, maxEndDay)){
                    maxEndMonth = current.end[0];
                    maxEndDay = current.end[1];
                    found = true;
                }

                index++;

            }

            if(!found){
                System.out.println(0);
                return;
            }

            currentMonth = maxEndMonth;
            currentDay = maxEndDay;
            count++;

        }


        System.out.println(count);

    }

    private static boolean isLaterDate(int m1, int d1, int m2, int d2){
        if(m1 != m2){
            return m1 > m2;
        }
        return d1 > d2;
    }
}