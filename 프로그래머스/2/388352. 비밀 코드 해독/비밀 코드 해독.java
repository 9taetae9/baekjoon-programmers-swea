import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        // 조합 리스트
        List<Set<Integer>> candidates = new ArrayList<>();
        combination(1, n, 5, new ArrayList<>(), candidates);
        
        int answer = 0;
        for(Set<Integer> candidate : candidates){
            if(isValid(candidate, q, ans)) answer++;
        }
        
        return answer;
    }
    
    
    private void combination(int start, int end, int target, List<Integer> current, List<Set<Integer>> candidates){
        // 종료 조건
        if(current.size() == target){
            candidates.add(new HashSet<>(current));
            return ;
        }
        
        for(int i=start; i<=end; i++){
            current.add(i);
            combination(i+1, end, target, current, candidates);
            current.remove(current.size()-1);
        }
    }
    
    private boolean isValid(Set<Integer> candidate, int[][] q, int[] ans){
        for(int i=0; i<q.length; i++){
            int matchCnt = 0;
            for(int e : q[i]){
                if(candidate.contains(e)){
                    matchCnt++;
                }
            }
            if(ans[i] != matchCnt){
                return false;
            }
        }
        return true;
    }
}