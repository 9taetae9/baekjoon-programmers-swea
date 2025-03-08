class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++){
            sb.append(Integer.toString(i).repeat(food[i]/2));
        }
        
        StringBuilder sbR = new StringBuilder(sb);

        return sb.append(0).append(sbR.reverse()).toString();
    }
}