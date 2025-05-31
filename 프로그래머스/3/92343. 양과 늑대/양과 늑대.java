import java.util.*;
class Solution {
    private static class State {
        int currentNode;    //현재 위치한 노드 번호
        int sheepCount;     // 현재까지 모은 양의 수
        int wolfCount;      // 현재까지 모은 늑대의 수
        HashSet<Integer> reachableNodes; // 현재 상황에서 방문 가능한 노드들

        public State(int currentNode, int sheepCount, int wolfCount,
            HashSet<Integer> reachableNodes) {
            this.currentNode = currentNode;
            this.sheepCount = sheepCount;
            this.wolfCount = wolfCount;
            this.reachableNodes = reachableNodes;
        }
    }

    // 트리 구조를 저장할 인접 리스트
    private static ArrayList<Integer>[] tree;

    private static void buildTree(int[][] edges) {
        tree = new ArrayList[edges.length + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
    }

    public static int solution(int[] info, int[][] edges) {
        //트리 구조 생성
        buildTree(edges);

        //최대 양의 수를 저장할 변수
        int maxSheep = 0;

        Deque<State> queue = new ArrayDeque<>();

        queue.offer(new State(0, 1, 0, new HashSet<>()));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            maxSheep = Math.max(maxSheep, current.sheepCount);

            // 현재 노드의 자식들을 "방문 가능한 노드" 목록에 추가
            // 한번 도달한 노드의 자식들은 언제든 방문 가능
            current.reachableNodes.addAll(tree[current.currentNode]);

            //방문 가능한 모든 노드에 대해 탐색
            for (int nextNode : current.reachableNodes) {
                //다음 상태를 위한 새로운 reachableNodes 생성
                //원본을 보존하기 위해 복사본 생성
                HashSet<Integer> nextReachableNodes = new HashSet<>(current.reachableNodes);
                nextReachableNodes.remove(nextNode);

                int nextSheepCount = current.sheepCount;
                int nextWolfCount = current.wolfCount;
                if (info[nextNode] == 0) {
                    nextSheepCount++;
                } else {
                    nextWolfCount++;

                    if (nextWolfCount >= nextSheepCount) {
                        continue;
                    }
                }

                queue.offer(new State(nextNode, nextSheepCount, nextWolfCount, nextReachableNodes));
            }
        }

        return maxSheep;
    }
}