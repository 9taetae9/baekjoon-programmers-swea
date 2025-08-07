import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static char[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<int[]> chocolates = new ArrayList<>();

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for(int i = 0; i<N; i++){
        	grid[i] = br.readLine().toCharArray();
        	for(int j=0; j<N; j++){
        		if(grid[i][j] == '#'){
        			chocolates.add(new int[]{i,j});
        		}
        	}
        }

        List<int[]> validPositions = new ArrayList<>();

        for (int[] pos : chocolates) {
            if (isValidRemoval(pos[0], pos[1])) {
                validPositions.add(new int[]{pos[0] + 1, pos[1] + 1});
            }
        }


        System.out.println(validPositions.size());
        for (int[] pos : validPositions) {
            System.out.println(pos[0] + " " + pos[1]);
        }
    }

    static boolean isValidRemoval(int removeR, int removeC) {
        grid[removeR][removeC] = '.';
        
        if (!isConnected(removeR, removeC)) {
            grid[removeR][removeC] = '#';
            return false;
        }
        
        if (!isTree()) {
            grid[removeR][removeC] = '#';
            return false;
        }
        
        grid[removeR][removeC] = '#';
        return true;
    }
    
    static boolean isConnected(int excludeR, int excludeC) {
        boolean[][] visited = new boolean[N][N];
        int startR = -1, startC = -1;
        
        for (int i = 0; i < N && startR == -1; i++) {
            for (int j = 0; j < N && startR == -1; j++) {
                if (grid[i][j] == '#') {
                    startR = i;
                    startC = j;
                }
            }
        }
        
        if (startR == -1) return false; 
        int visitedCount = dfs(startR, startC, visited);
        
        int totalChocolates = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '#') totalChocolates++;
            }
        }
        
        return visitedCount == totalChocolates;
    }
    
    static int dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        int count = 1;
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && 
                !visited[nr][nc] && grid[nr][nc] == '#') {
                count += dfs(nr, nc, visited);
            }
        }
        
        return count;
    }
    
    static boolean isTree() {
        int nodeCount = 0;
        int edgeCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '#') {
                    nodeCount++;
                    
                    if (i + 1 < N && grid[i + 1][j] == '#') edgeCount++;
                    if (j + 1 < N && grid[i][j + 1] == '#') edgeCount++;
                }
            }
        }

        return edgeCount == nodeCount - 1;
    }
}