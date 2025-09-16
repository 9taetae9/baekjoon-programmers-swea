import java.util.*;
import java.util.stream.*;
class Solution {
    int len;
    public int[] solution(String[] genres, int[] plays) {
        len = genres.length;
        //장르별 총 재생 횟수
        Map<String, Integer> playMap = new HashMap<>();
        // 장르별 곡 리스트(int[]{재생횟수, 고유번호}) 
        Map<String, ArrayList<int[]>> genresMap = new HashMap<>();
        for(int i=0; i<len; i++){
            genresMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
            playMap.put(genres[i], playMap.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        
        //총 재생 횟수가 많은 장르순으로 내림 차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenres = 
            playMap.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        List<Integer> answer = new ArrayList<>();
    
        Comparator<int[]> songComparator =
            Comparator.<int[]>comparingInt(a -> a[1]).reversed()
                    .thenComparing(a -> a[0]);
        
        //각 장르 내에서 노래를 재생 횟수 순으로 정렬해 최대 2곡까지 선택
        sortedGenres.forEach(entry -> {
            genresMap.get(entry.getKey()).stream()
                .sorted(songComparator)
                .limit(2)
                .forEach(song -> answer.add(song[0]));
        });
            
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
정렬순
1. 장르(내림차순)
2. 재생 횟수(내림차순)
3. 고유 번호(오름차순)
*/