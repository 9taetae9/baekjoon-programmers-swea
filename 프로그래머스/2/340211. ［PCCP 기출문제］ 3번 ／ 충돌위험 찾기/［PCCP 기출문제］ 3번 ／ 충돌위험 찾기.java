import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<String, Integer> countMap = new HashMap<>(); // "time_r_c"를 키로 사용
        int collision = 0;

        for (int i = 0; i < routes.length; i++) {
            int time = 0; // 각 로봇마다 개별 시간 추적

            for (int j = 0; j < routes[i].length - 1; j++) {
                int[] start = points[routes[i][j] - 1];
                int[] end = points[routes[i][j + 1] - 1];

                int curR = start[0], curC = start[1];
                int nextR = end[0], nextC = end[1];

                // r 좌표 이동
                while (curR != nextR) {
                    String key = time + "_" + curR + "_" + curC; // 고유한 키 생성
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                    if (countMap.get(key) == 2) { // 충돌 조건 (2대 이상 로봇이 모이면 위험)
                        collision++;
                    }
                    curR += (curR < nextR) ? 1 : -1;
                    time++;
                }

                // c 좌표 이동
                while (curC != nextC) {
                    String key = time + "_" + curR + "_" + curC;
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                    if (countMap.get(key) == 2) {
                        collision++;
                    }
                    curC += (curC < nextC) ? 1 : -1;
                    time++;
                }
            }

            // 마지막 포인트 체크
            int lastR = points[routes[i][routes[i].length - 1] - 1][0];
            int lastC = points[routes[i][routes[i].length - 1] - 1][1];
            String key = time + "_" + lastR + "_" + lastC;
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            if (countMap.get(key) == 2) {
                collision++;
            }
        }

        return collision;
    }
}