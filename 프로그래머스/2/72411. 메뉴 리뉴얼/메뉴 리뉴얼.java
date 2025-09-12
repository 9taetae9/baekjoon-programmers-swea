import java.util.*;

class Solution {
    //만들 수 잇는 메뉴 구성과 총 주문 수를 저장할 해시맵
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    
    public String[] solution(String[] orders, int[] course){
        // 해시맵 초기화
        courseMap = new HashMap<>();
        for(int i : course){
            courseMap.put(i, new HashMap<>());
        }
        
        // 코스를 배열로 만들고 오름차순으로 정렬해서 가능한 모든 메뉴 구성을 구함
        for(String order : orders){
            //ABCFG
            char[] orderArray = order.toCharArray(); //A B C F G
            Arrays.sort(orderArray);
            combinations(0, orderArray, new StringBuilder());
        }
        
        List<String> answer = new ArrayList<>();
        
        for(HashMap<String, Integer> count : courseMap.values()){
            count.values()
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> count.entrySet()
                          .stream()
                          .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                          .forEach(entry -> answer.add(entry.getKey())));
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
        
    }
    
    //만들 수 있는 모든 조합을 재귀 함수를 이용해서 구현
    public static void combinations(int idx, char[] order, StringBuilder sb){
        if(courseMap.containsKey(sb.length())){// 해당 길이의 메뉴 구성 해시맵
            HashMap<String, Integer> map = courseMap.get(sb.length());
            // 해당 코스의 수를 1증가
            String comb = sb.toString();
            map.put(comb, map.getOrDefault(comb, 0) + 1);
        }
        
        for(int i=idx; i < order.length; i++){
            sb.append(order[i]);
            combinations(i+1, order, sb);
            sb.setLength(sb.length()-1);
        }
    }
    
    
}