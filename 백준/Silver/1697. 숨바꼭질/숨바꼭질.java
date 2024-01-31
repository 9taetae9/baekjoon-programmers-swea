import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static  FastReader scan = new FastReader();
    static  StringBuilder sb = new StringBuilder();
    static int N, K;
    static boolean[] visit = new boolean[100001];
    static int[] dist = new int[100001];

    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();

    }
    static void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        visit[N] = true;
        dist[N] = 0;

        while(!que.isEmpty()){
            int x = que.poll();
            int y = x-1;
            if(0 <= y && !visit[y]){
                visit[y] = true;
                dist[y] = dist[x]+1;
                que.add(y);
            }

            y=x+1;
            if(0<=y && y<=100000 && !visit[y]){
                visit[y] = true;
                dist[y] = dist[x]+1;
                que.add(y);
            }

            y=2*x;
            if(0<=y && y<=100000 && !visit[y]){
                visit[y] = true;
                dist[y] = dist[x]+1;
                que.add(y);
            }
        }
    }

    static void pro(){
        bfs();
        System.out.println(dist[K]);
    }


    public static void main(String[] args){
        input();
        pro();
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}