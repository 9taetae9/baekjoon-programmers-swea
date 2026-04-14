import java.util.*;

class Solution {
    class Task {
        String name;
        int start, playtime;
        
        public Task(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Task> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.start));
        Deque<Task> stack = new ArrayDeque<>();
        
        for(String[] plan : plans){
            String name = plan[0];
            int start = getMins(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            
            queue.add(new Task(name, start, playtime));
        }
        
        int idx = 0;
        while(queue.size() >= 2){
            Task curr = queue.poll();
            Task next = queue.peek();
            
            int availableTime = next.start - curr.start;
            
            if(availableTime < curr.playtime){
                curr.playtime -= availableTime;
                stack.push(curr);
                availableTime = 0;
            }else if(availableTime > curr.playtime){
                availableTime -= curr.playtime;
                answer[idx++] = curr.name;
            }else{
                availableTime = 0;
                answer[idx++] = curr.name;
            }
            
            while(!stack.isEmpty() && availableTime > 0){
                curr = stack.pop();
                
                if(availableTime < curr.playtime){
                    curr.playtime -= availableTime;
                    stack.push(curr);
                    availableTime = 0;
                }else if(availableTime > curr.playtime){
                    availableTime -= curr.playtime;
                    answer[idx++] = curr.name;
                }else{
                    availableTime = 0;
                    answer[idx++] = curr.name;
                }
            }
        }
        
        if(!queue.isEmpty()){
            Task curr = queue.poll();
            answer[idx++] = curr.name;
        }
        while(!stack.isEmpty()){
            answer[idx++] = stack.pop().name;
        }
        
        return answer;
    }
    
    private int getMins(String time){
        String[] part = time.split(":");
        int hour = Integer.parseInt(part[0]);
        int min = Integer.parseInt(part[1]);
        
        return hour * 60 + min;
    }
}