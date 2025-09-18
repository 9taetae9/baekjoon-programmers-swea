import java.util.*;

class Solution {
    private static class Task implements Comparable<Task>{
        int num;
        int requestedTime;
        int requiredTime;
        
        public Task(int num, int requestedTime, int requiredTime){
            this.num = num;
            this.requestedTime = requestedTime;
            this.requiredTime = requiredTime;
        }
        
        @Override
        public int compareTo(Task o){
            return Comparator.comparingInt((Task t) -> t.requiredTime)
                            .thenComparingInt(t -> t.requestedTime)
                            .thenComparingInt(t -> t.num)
                            .compare(this, o);
        }
    }
    
    public int solution(int[][] jobs) {
        //작업 요청 시간 순 오름 차순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Task> readyQueue = new PriorityQueue<>();
        int len = jobs.length;
        int total = 0;
        int jobProcessed = 0;
        int jobIdx = 0;
        int currTime = 0;
        
        while(jobProcessed < len){
            while(jobIdx < len && jobs[jobIdx][0] <= currTime){
                readyQueue.offer(new Task(jobIdx, jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }
            
            if(!readyQueue.isEmpty()){
                Task currTask = readyQueue.poll();
                
                currTime += currTask.requiredTime;
                
                total += (currTime - currTask.requestedTime);
                
                jobProcessed++;
            }else{//디스크 유효시간 (다음 작업 요청으로 현재 시각 점프)
                currTime = jobs[jobIdx][0];
            }
        }
        
        
        return total / len;
    }
}