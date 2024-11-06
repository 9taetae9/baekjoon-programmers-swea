import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> worker = new HashMap<>(); // worker 사원 : 추천 사원
        Map<String, Integer> income = new HashMap<>();
        for(int i=0; i < enroll.length; i++){
            worker.put(enroll[i], referral[i]);
            income.put(enroll[i], 0);
        }

        for(int i=0; i < seller.length; i++){
            String currentSeller = seller[i];
            int currentIncome = amount[i] * 100;

            while(!currentSeller.equals("-") && currentIncome > 0){
                int shareIncome = currentIncome/10;
                int earn = currentIncome - shareIncome;
                income.put(currentSeller, income.get(currentSeller)+earn);

                currentSeller = worker.get(currentSeller);
                currentIncome = shareIncome;
            }
        }

        int[] answer = new int[enroll.length];

        for(int i=0; i<enroll.length; i++){
            answer[i] = income.get(enroll[i]);
        }

        return answer;
    }
}