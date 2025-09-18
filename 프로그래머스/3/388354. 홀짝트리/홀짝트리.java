import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        //[홀짝 트리 개수, 역홀짝 트리 개수]
        int[] answer = {0, 0};
        
        // 노드번호가 크고 비연속적이므로 HashMap 사용
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degrees = new HashMap<>();
        
        //그래프 초기화
        for(int node: nodes){
            graph.put(node, new ArrayList<>());
            degrees.put(node, 0);
        }
        // 간선 정보로 그래프 및 차수 정보 채우기
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
            
            degrees.put(u, degrees.get(u)+1);
            degrees.put(v, degrees.get(v)+1);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        // 모든 노드를 순회하며 아직 방문하지 않은 노드에서 탐색 시작 (포레스트 처리)
        for(int startNode : nodes){
            if(!visited.contains(startNode)){
                List<Integer> currentTreeNodes = new ArrayList<>();
                Deque<Integer> queue = new ArrayDeque<>();
                
                queue.add(startNode);
                visited.add(startNode);
                
                while(!queue.isEmpty()){
                    int u = queue.poll();
                    currentTreeNodes.add(u);
                    
                    for(int v : graph.get(u)){
                        if(!visited.contains(v)){
                            visited.add(v);
                            queue.add(v);
                        }
                    }
                }
                
                // 현재 트리 분석
                int sameParityCount = 0; // P(번호) == P(차수) 인 노드의 수
                
                for(int nodeNum : currentTreeNodes){
                    int degree = degrees.get(nodeNum);
                    
                    if((nodeNum % 2) == (degree % 2)){
                        sameParityCount++;
                    }
                }
                
                // 홀짝 트리 판별
                if(sameParityCount == 1){
                    answer[0]++;
                }
                
                // 역홀짝 트리 판별
                if(currentTreeNodes.size() - sameParityCount == 1){
                    answer[1]++;
                }
            }
        }
        
    
        return answer;
    }
}