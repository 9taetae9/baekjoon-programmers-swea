import java.util.*;

class Solution {
    //n, 2, 3
    public int solution(int x, int y, int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(x);
        
        int cnt = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int q = queue.poll();
                
                if(q == y) return cnt;
                if(q > y) continue;
            
                if(q+n <= y && !visited.contains(q+n)) {
                    queue.add(q+n);
                    visited.add(q+n);
                }
                if(q*2 <= y && !visited.contains(q*2)){
                    queue.add(q*2);
                    visited.add(q * 2);
                }
                if (q * 3 <= y && !visited.contains(q * 3)) {
                    queue.add(q * 3);
                    visited.add(q * 3);
                }
            }
            cnt++;
        }
        
        return -1;
    }
    
    
}