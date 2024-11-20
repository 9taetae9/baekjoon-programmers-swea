import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int N, M;
    static ArrayList<Point> homes;    // 집들의 위치
    static ArrayList<Point> chickens; // 치킨집들의 위치
    static boolean[] selected;        // 선택된 치킨집 표시
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 집과 치킨집 위치 저장을 위한 리스트 초기화
        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        
        // 도시 정보 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    homes.add(new Point(i, j));       // 집 위치 저장
                } else if (value == 2) {
                    chickens.add(new Point(i, j));    // 치킨집 위치 저장
                }
            }
        }
        
        selected = new boolean[chickens.size()];
        
        // 치킨집 선택 및 거리 계산 시작
        selectChicken(0, 0);
        
        // 결과 출력
        System.out.println(answer);
    }
    
    // 치킨집 M개를 선택하는 조합 함수
    static void selectChicken(int start, int count) {
        // M개의 치킨집이 선택되면 거리 계산
        if (count == M) {
            calculateDistance();
            return;
        }
        
        // 백트래킹으로 치킨집 선택
        for (int i = start; i < chickens.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                selectChicken(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }
    
    // 선택된 치킨집들과 모든 집들 사이의 치킨 거리 계산
    static void calculateDistance() {
        int totalDistance = 0;
        
        // 각 집에 대하여
        for (Point home : homes) {
            int minDistance = Integer.MAX_VALUE;
            
            // 선택된 치킨집들과의 거리를 계산하여 최소값 찾기
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    Point chicken = chickens.get(i);
                    int distance = Math.abs(home.x - chicken.x) + 
                                 Math.abs(home.y - chicken.y);
                    minDistance = Math.min(minDistance, distance);
                }
            }
            
            totalDistance += minDistance;
        }
        
        // 전체 도시의 최소 치킨 거리 갱신
        answer = Math.min(answer, totalDistance);
    }
}