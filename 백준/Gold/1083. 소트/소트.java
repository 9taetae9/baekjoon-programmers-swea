import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		
		arr = new ArrayList<>();
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); 
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(stringTokenizer.nextToken()));
		}
		
		int S = Integer.parseInt(bufferedReader.readLine());
		
		for(int i=0; i < N; i++) {
			int maxIndex = i; 
			for(int j=i+1; j<N &&j-i<=S; j++ ) {
				if(arr.get(maxIndex)<arr.get(j)) maxIndex = j;
			}
			
			for(int j=maxIndex; j>i; j--) {
				Collections.swap(arr, j, j-1);
			}
			
			S -= (maxIndex - i);
		}
		
		for(int e : arr) {
			System.out.print(e+" ");
		}	
	}
}
