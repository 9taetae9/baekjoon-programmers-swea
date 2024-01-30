import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class State{
    int[] X;
    State(int[] _X){
        X = new int[3];
        for(int i=0; i<3; i++) X[i] = _X[i];
    }

    State move(int from, int to, int[] Limit){
        int[] nX = new int[]{X[0], X[1], X[2]};
        if(X[from]+X[to]>=Limit[to]) {
            nX[from] -= Limit[to]-X[to];
            nX[to]  = Limit[to];
        }else{
            nX[to] += nX[from];
            nX[from] = 0;
        }
        return new State(nX);
    }
}
public class Main{
    static  FastReader scan = new FastReader();
    static  StringBuilder sb = new StringBuilder();
    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;
    static void input(){
        Limit = new int[3];
        for(int i=0; i<3; i++) Limit[i] = scan.nextInt();
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }
    static void bfs(int x1, int x2, int x3){
        Queue<State> que = new LinkedList<>();
        visit[x1][x2][x3] = true;
        que.add(new State(new int[]{x1,x2,x3}));

        while(!que.isEmpty()){
            State st = que.poll();
            if(st.X[0] == 0) possible[st.X[2]] = true;
            for(int from=0; from<3; from++){
                for(int to = 0; to<3; to++){
                    if(from == to) continue;
                    State nxt = st.move(from, to, Limit);

                    if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]){
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        que.add(nxt);
                    }
                }
            }
        }
    }

    static void pro(){
        bfs(0,0,Limit[2]);

        for(int i=0; i<=Limit[2]; i++){
            if(possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
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