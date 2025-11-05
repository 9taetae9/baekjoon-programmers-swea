import java.util.*;

class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        
        //1. game_baord에서 빈 공간(0) 추출
        List<List<int[]>> emptySpaces = extractShapes(game_board, 0);
        
        //2. table에서 조각(1) 추출
        List<List<int[]>> pieces = extractShapes(table, 1);
        
        //3. 각 조각을 사용했는지 체크
        boolean[] usedPieces = new boolean[pieces.size()];
        int totalFilled = 0;
        
        //4. 각 빈 공간에 대해 매칭 시도
        for(List<int[]> emptySpace : emptySpaces){
            //빈 공간 정규화
            List<int[]> normalizedEmpty = normalize(emptySpace);
            
            // 모든 조각 시도 
            for(int i=0; i<pieces.size(); i++){
                if(usedPieces[i]) continue;
                
                if(tryMatch(normalizedEmpty, pieces.get(i))){
                    usedPieces[i] = true;
                    totalFilled += emptySpace.size();
                    break;
                }
            }
        }
        
        return totalFilled;
    }
    
    // BFS로 연결된 영역 추출
    private List<List<int[]>> extractShapes(int[][] board, int target){
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && board[i][j] == target){
                    List<int[]> shape = bfs(board, visited, i, j, target);
                    shapes.add(shape);
                }
            }
        }
        
        return shapes;
    }
    
    private List<int[]> bfs(int[][] board, boolean[][] visited, int startX, int startY, int target){
        int n = board.length;
        List<int[]> shape = new ArrayList<>();
        Deque<int[]> queue = new ArrayDeque<>();
        
        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            shape.add(new int[]{x, y});
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                if(!visited[nx][ny] && board[nx][ny] == target){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        return shape;
    }
    /**
    좌표를 (0,0) 기준으로 정규화
    최소 x, y 좌표를 0으로 만들고 정렬
    */
    private List<int[]> normalize(List<int[]> shape){
        if(shape.isEmpty()) return shape;
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int[] pos : shape){
            minX = Math.min(minX, pos[0]);
            minY = Math.min(minY, pos[1]);
        }
        
        List<int[]> normalized = new ArrayList<>();
        for(int[] pos : shape){
            normalized.add(new int[]{pos[0] - minX, pos[1] - minY});
        }
        
        normalized.sort((a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        return normalized;
    }
    
    /**
    조각을 90도 회전
    (x, y) -> ()
    */
    private List<int[]> rotate90(List<int[]> shape){
        List<int[]> rotated = new ArrayList<>();
        
        for(int[] pos : shape){
            rotated.add(new int[]{pos[1], -pos[0]});
        }
        
        return normalize(rotated);
    }
    
    /**
    빈 공간과 조각이 매칭되는지 확인
    0도, 90도, 180도, 270도 회전을 모두 시도
    */
    
    private boolean tryMatch(List<int[]> emptySpace, List<int[]> piece){
        if(emptySpace.size() != piece.size()){
            return false;
        }
        
        List<int[]> currentPiece = normalize(piece);
        
        for(int rotation = 0; rotation < 4; rotation++){
            if(isSameShape(emptySpace, currentPiece)){
                return true;
            }
            
            currentPiece = rotate90(currentPiece);
        }
        
        return false;
    }
    
    private boolean isSameShape(List<int[]> shape1, List<int[]> shape2){
        if(shape1.size() != shape2.size()){
            return false;
        }
        
        for(int i = 0; i<shape1.size(); i++){
            if(shape1.get(i)[0] != shape2.get(i)[0] ||
              shape1.get(i)[1] != shape2.get(i)[1]){
                return false;
            }
        }
        
        return true;
    }
    
}

/**
회전 가능
새로 채워 넣는 퍼즐 조각은 인접한 칸과 붙어있어야함

1. 조각과 빈 공간 추출
- BFS/DFS로 연결된 영역을 찾아 각각의 조각과 빈 공간을 추출
2. 좌표 정규화
- 추출한 조각을 (0,0) 기준으로 정규화하여 비교 가능하게 만듬
3. 회전 구현
- 0, 90, 180, 270도 회전을 시도
4. 매칭
각 빈 공간에 대해 모든 조각의 모든 회전 상태를 시도
매칭되면 해당 조각 사용 처리
*/
