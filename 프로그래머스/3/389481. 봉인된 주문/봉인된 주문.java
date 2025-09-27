import java.util.*;

class Solution {
    //26의 거듭제곱 미리 계산
    long[] power26;
    
    public String solution(long n, String[] bans) {
        initPower26();
        List<Long> banIndices = new ArrayList<>();
        for(String ban : bans){
            banIndices.add(wordToIndex(ban));
        }
        Collections.sort(banIndices);
        
        long left = 1;
        long right = n + bans.length;
        long answerIndex = 0;
        
        while(left <= right){
            long mid = left +  (right - left) / 2;
            
            //mid번까지 살아남은 주문 수
            long bannedCount = countBannedBefore(mid, banIndices);
            long survivedCount = mid - bannedCount;
            
            if(survivedCount >= n){
                answerIndex = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return indexToWord(answerIndex);
    }
    
    
    private long countBannedBefore(long k, List<Long> banIndices){
        int left = 0;
        int right = banIndices.size() - 1;
        int count = 0;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(banIndices.get(mid) <= k){
                count = mid + 1;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return count;
    }
    
    private long wordToIndex(String word){
        long index = 0;
        //word보다 길이 작은 글자 수
        for(int i = 1; i < word.length(); i++){
            index += power26[i];
        }
        //word 동일 길이에서 번째수
        long sameLengthOrder = 0;
        for(int i=0; i < word.length(); i++){
            sameLengthOrder = sameLengthOrder * 26 + (word.charAt(i) - 'a');
        }
        return index + sameLengthOrder + 1;
    }
    
    private String indexToWord(long index){
        int length = 1;
        while(index > power26[length]){
            index -= power26[length];
            length++;
        }
        index--;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< length; i++){
            sb.append((char) ('a' + (index % 26)));
            index /= 26;
        }
        
        return sb.reverse().toString();
    }
    
    private void initPower26(){
        power26 = new long[12];
        power26[0] = 1;
        for(int i=1; i < 12; i++){
            power26[i] = power26[i-1] * 26;
        }
    }
}