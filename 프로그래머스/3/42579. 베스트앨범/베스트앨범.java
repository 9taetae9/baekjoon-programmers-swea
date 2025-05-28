import java.util.*; 
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> genreMap = new HashMap<>(); //{횟수, 아이디}
        Map<String, Integer> playMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            if(!genreMap.containsKey(genres[i])){
                genreMap.put(genres[i], new ArrayList<>());
                playMap.put(genres[i], 0);
            }
            
            genreMap.get(genres[i]).add(new int[]{plays[i], i});
            playMap.put(genres[i], playMap.get(genres[i])+plays[i]);
        }
        
        Stream<Map.Entry<String,Integer>> sortedGenre = playMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        List<Integer> answer = new ArrayList<>();
        
        //각 장르내에서 top2 선정
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                .sorted((o1, o2) -> Integer.compare(o2[0], o1[0]))
                .limit(2);
            sortedSongs.forEach(song -> answer.add(song[1]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}