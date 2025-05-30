import java.util.*;

class Solution {
    private static List<String> result = new ArrayList<>();
    private static Map<Integer, Map<String, Integer>> countMap = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        
        
        for(int c : course){
            countMap.put(c, new HashMap<>());
        }
        
        for(String order : orders){
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            combination(0, orderArr, "");
        }
        
        for(Map<String, Integer> count : countMap.values()){
            count.values().stream()
                .max(Comparator.comparingInt(o->o))
                .ifPresent(cnt -> count.entrySet().stream()
                                .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                                .forEach(entry -> result.add(entry.getKey())));
        }
        
        Collections.sort(result);
        return result.toArray(new String[0]);
        
        
    }
    
    private void combination(int idx, char[] order, String current){
        if(countMap.containsKey(current.length())){
            countMap.get(current.length()).merge(current, 1, Integer::sum);
        }
        
        for(int i=idx; i<order.length; i++){
            combination(i+1, order, current + order[i]);
        }
    }
    
    
}