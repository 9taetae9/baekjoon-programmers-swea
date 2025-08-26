import java.util.*;
import java.io.*;


public class Main{

	static int N, M;
	static char[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][][][] visited;

	static class State{
		int rx, ry;
		int bx, by;
		int move;

		public State(int rx, int ry, int bx, int by, int move){
			this.rx = rx; 
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.move = move;
		}
	}

	// 구슬의 현재 x, y 좌표와 이동 방향 dx, dy를 받아서
	// 이동 후의 새로운 위치와 이동 거리를 반환
	static private int[] moveMarble(int x, int y, int dirX, int dirY){
		int moveCount = 0;

		while(board[x + dirX][y + dirY] != '#'){
			x += dirX;
			y += dirY;
			moveCount++;
			if(board[x][y] == 'O'){
				break;
			}
		}

		return new int[]{x,y, moveCount};
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] part = br.readLine().split(" ");
		N = Integer.parseInt(part[0]);
		M = Integer.parseInt(part[1]);

		//  '.', '#', 'O', 'R', 'B'
		board = new char[N][M];
		State start = new State(0,0,0,0,0);

		for(int i=0; i<N; i++){
			String line = br.readLine();
			for(int j=0; j<M; j++){
				board[i][j] = line.charAt(j);
				if(board[i][j] == 'R'){
					start.rx = i;
					start.ry = j;
				}else if(board[i][j] == 'B'){
					start.bx = i;
					start.by = j;
				}
			}
		}


		//BFS
		Deque<State> queue = new ArrayDeque<>();
		visited = new boolean[N][M][N][M];

		queue.offer(start);
		visited[start.rx][start.ry][start.bx][start.by] = true;
		
		while(!queue.isEmpty()){
			State curr = queue.poll();

			//10번 탐색했으면 더 이상 탐색 x
			if(curr.move >= 10){
				continue;
			}


			//상하좌우 기울이기 시도
			for(int i=0; i<4; i++){
				int[] rResult, bResult;

				if((i == 0 && curr.rx < curr.bx) || //up
				   (i == 1 && curr.rx > curr.bx) || //down
				   (i == 2 && curr.ry < curr.by) || //left
				   (i == 3 && curr.ry > curr.by)){  //right
					rResult = moveMarble(curr.rx, curr.ry, dx[i], dy[i]);
					bResult = moveMarble(curr.bx, curr.by, dx[i], dy[i]);
				}else{
					bResult = moveMarble(curr.bx, curr.by, dx[i], dy[i]);
					rResult = moveMarble(curr.rx, curr.ry, dx[i], dy[i]);
				}

				int nrx = rResult[0], nry = rResult[1];
				int nbx = bResult[0], nby = bResult[1];

				//check the results after move
				if(board[nbx][nby] == 'O'){
					continue;
				}

				if(board[nrx][nry] == 'O'){
					System.out.println(1);
					return;
				}

				// handle collision
				if(nrx == nbx && nry == nby){
					if(rResult[2] > bResult[2]){//red moved further
						nrx -= dx[i];
						nry -= dy[i];
					}else {//blue moved futher or same
						nbx -= dx[i];
						nby -= dy[i];
					}
				}

				if(!visited[nrx][nry][nbx][nby]){
					visited[nrx][nry][nbx][nby] = true;
					queue.offer(new State(nrx, nry, nbx, nby, curr.move + 1));
				}
			}
		}

		System.out.println(0);
	}
}