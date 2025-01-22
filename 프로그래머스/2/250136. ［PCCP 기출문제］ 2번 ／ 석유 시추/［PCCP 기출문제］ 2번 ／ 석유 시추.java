import java.util.*;

class Solution {
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[][] visited = new int[n][m];

        Queue<int[]> queue = new ArrayDeque<>();
        Map<Integer, Integer> groupAmount = new HashMap<>();
        int group = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    visited[i][j] = group;
                    queue.offer(new int[]{i,j});
                    int amount = 0;
                    while(!queue.isEmpty()){
                        amount++;
                        int[] cur = queue.poll();

                        for(int d=0; d<4; d++){
                            int nextN = cur[0] + dx[d];
                            int nextM = cur[1] + dy[d];

                            if(nextN < 0 || nextN >= n || nextM < 0 || nextM >= m) continue;
                            if(visited[nextN][nextM] !=0 || land[nextN][nextM] == 0)
                                continue;

                            visited[nextN][nextM] = group;
                            queue.offer(new int[]{nextN, nextM});
                        }
                    }
                    groupAmount.put(group, amount);
                    group++;
                }
            }
        }

        int maxAmount = 0;
        Set<Integer> possibleGroup = new HashSet<>();
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                int groupId = visited[j][i];
                if(groupId > 0 && !possibleGroup.contains(groupId)){
                    possibleGroup.add(groupId);
                    sum += groupAmount.get(groupId);
                }
            }
            possibleGroup.clear();
            maxAmount = Math.max(maxAmount,sum);
        }
        
        return maxAmount;
    }
}