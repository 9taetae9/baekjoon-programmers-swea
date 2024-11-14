import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = Integer.MAX_VALUE;
        
        // 모든 멘토 배치를 조합하는 함수
        List<int[]> combinations = generateMentorCombinations(n, k);

        // 각 조합에 대해 대기 시간 계산
        for (int[] combination : combinations) {
            int waitTime = calculateWaitTime(combination, k, reqs);
            answer = Math.min(answer, waitTime);
        }
        
        return answer;
    }
    
    // 멘토 배치 조합을 생성하는 함수
    private List<int[]> generateMentorCombinations(int n, int k) {
        List<int[]> result = new ArrayList<>();
        backtrack(result, new int[k], n, 0);
        return result;
    }
    
    // 백트래킹을 사용하여 n명을 k 그룹에 나누는 모든 조합 생성
    private void backtrack(List<int[]> result, int[] current, int remaining, int index) {
        if (index == current.length - 1) {
            current[index] = remaining;
            result.add(current.clone());
            return;
        }
        
        for (int i = 1; i <= remaining - (current.length - index - 1); i++) {
            current[index] = i;
            backtrack(result, current, remaining - i, index + 1);
        }
    }
    
    // 특정 멘토 배치 조합에서 대기 시간을 계산하는 함수
    private int calculateWaitTime(int[] mentors, int k, int[][] reqs) {
        int totalWaitTime = 0;
        
        // 각 상담 유형별 멘토의 우선순위 큐 생성
        PriorityQueue<Integer>[] mentorQueues = new PriorityQueue[k];
        for (int i = 0; i < k; i++) {
            mentorQueues[i] = new PriorityQueue<>();
            for (int j = 0; j < mentors[i]; j++) {
                mentorQueues[i].offer(0); // 초기 시간 0
            }
        }
        
        // 각 요청을 처리하면서 대기 시간 계산
        for (int[] req : reqs) {
            int requestTime = req[0];
            int consultationTime = req[1];
            int type = req[2] - 1;
            
            // 선택한 유형의 멘토 중 가장 빠르게 끝나는 시간에 배치
            int startTime = mentorQueues[type].poll();
            int waitTime = Math.max(0, startTime - requestTime);
            totalWaitTime += waitTime;
            
            // 상담 종료 시간 갱신 후 다시 큐에 삽입
            mentorQueues[type].offer(Math.max(startTime, requestTime) + consultationTime);
        }
        
        return totalWaitTime;
    }
}