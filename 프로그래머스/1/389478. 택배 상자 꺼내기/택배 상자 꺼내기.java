import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        List<List<Integer>> boxes = new ArrayList<>();
        for(int i=0; i<w; i++){
            boxes.add(new ArrayList<>());
        }
        
        int a = 1;
        while(a<=n){
            for(int i=0; i<w; i++){
                boxes.get(i).add(a++);
                if(a>n) break;
            }
            if(a>n) break;
            for(int j = w-1; j>=0; j--){
                boxes.get(j).add(a++);
                if(a>n) break;
            }
        }
        
        for(int i=0; i<w; i++){
            int cnt = 1;
            List<Integer> line = boxes.get(i);
            for(int j=line.size()-1; j>=0; j--){
                System.out.println(line.get(j));
                if(line.get(j) == num){
                    return cnt;
                }
                cnt++;
            }
        }
        
        return 0;
    }
}