import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        Map<Integer,String> playerMap = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            rank.put(players[i], i);
            playerMap.put(i, players[i]);
        }
        
        for(String calling : callings){
            int calledRank = rank.get(calling); // K, 3
            String loser = playerMap.get(calledRank-1); //2, G 

            rank.put(calling, calledRank-1); // K, 2 
            playerMap.put(calledRank-1,calling); // 2, K 
            
            rank.put(loser, calledRank); // G, 3
            playerMap.put(calledRank, loser); // 3, G
        }
        String[] answer = new String[players.length];
        for(int i=0; i<players.length; i++){
            answer[i] = playerMap.get(i);
        }
        return answer;
    }
}