import java.io.*;
import java.util.*;

public class Main {

	static class Problem implements Comparable<Problem>{
		int deadLine;
		int ramen;

		Problem(int deadLine, int ramen){
			this.deadLine = deadLine;
			this.ramen = ramen;
		}

		public int compareTo(Problem other){
			return this.deadLine - other.deadLine;
		}
	}

	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

       	

        Problem[] problems = new Problem[N];
        for(int i=0; i < N; i++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int deadLine = Integer.parseInt(st.nextToken());
        	int ramen = Integer.parseInt(st.nextToken());
        	problems[i] = new Problem(deadLine, ramen);
        }	

        Arrays.sort(problems);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Problem p : problems){
        	pq.offer(p.ramen);
        	if(pq.size() > p.deadLine){
        		pq.poll();
        	}
        }

        long total = 0;
        while(!pq.isEmpty()){
        	total += pq.poll();
        }

        System.out.println(total);
    }
}