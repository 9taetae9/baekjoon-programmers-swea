import java.util.*;

class Solution {
    static class Song {
        int id;
        int plays;
        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 1) 장르별 총 재생량 계산 및 장르별 노래 리스트 구성
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            totalPlays.put(g, totalPlays.getOrDefault(g, 0) + p);
            songsByGenre.computeIfAbsent(g, k -> new ArrayList<>()).add(new Song(i, p));
        }

        // 2) 장르 내에서 노래 정렬: plays 내림, id 오름
        for (List<Song> list : songsByGenre.values()) {
            
            list.sort((a, b) -> {
                return (b.plays == a.plays) 
                    ? Integer.compare(a.id, b.id) : Integer.compare(b.plays, a.plays);}
            );
        }
        
        //장르를 총 재생량 기준으로 정렬
        List<String> genreList = new ArrayList<>(totalPlays.keySet());
        genreList.sort((a, b) -> {return Integer.compare(totalPlays.get(b), totalPlays.get(a));});
        
        //상위 2곡 씩 선택
        List<Integer> result = new ArrayList<>();
        for(String g : genreList){
            List<Song> list = songsByGenre.get(g);
            if(list.size() >= 1) result.add(list.get(0).id);
            if(list.size() >= 2) result.add(list.get(1).id);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
