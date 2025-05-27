import java.util.*;

class Song{
    public int sid; //고유 아이디
    public int cnt; //재생 횟수
    
    public Song(){}
    public Song(int sid, int cnt){
        this.sid = sid;
        this.cnt = cnt;
    }
    
    public int getSid(){
        return sid;
    }
    
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> genresToSongs = new HashMap<>(); //장르별 곡 리스트
        Map<String, Integer> genresToPlays = new HashMap<>(); //각 장르별 총 횟수
        for(int i=0; i<genres.length; i++){
            String g = genres[i]; //장르
            if(!genresToSongs.containsKey(g)){
                genresToSongs.put(g, new ArrayList<>());
            }
            genresToSongs.get(g).add(new Song(i, plays[i]));
            genresToPlays.put(g, genresToPlays.getOrDefault(g, 0)+plays[i]);
        }
        
        List<Integer> genresPlays = new ArrayList<>();
        Map<Integer, String> playsToGenres = new HashMap<>();
        for(Map.Entry<String, Integer> entry: genresToPlays.entrySet()){
            genresPlays.add(entry.getValue());
            playsToGenres.put(entry.getValue(), entry.getKey());
        }
        
        Collections.sort(genresPlays);
        
        List<Integer> answer = new ArrayList<>();
        for(int i=genresPlays.size()-1; i>=0; i--){
            String genre = playsToGenres.get(genresPlays.get(i));
            List<Song> songs = genresToSongs.get(genre);
            songs.sort((a, b) -> b.cnt != a.cnt ? b.cnt - a.cnt : a.sid - b.sid);
            for(int j=0; j<songs.size() && j<2; j++){
                answer.add(songs.get(j).getSid());
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}