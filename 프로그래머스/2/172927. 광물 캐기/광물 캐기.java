import java.util.*;

class Solution {
    
    class MineralGroup {
        int dCost;
        int iCost;
        int sCost;
        
        public MineralGroup(int dCost, int iCost, int sCost){
            this.dCost = dCost;
            this.iCost = iCost;
            this.sCost = sCost;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = totalPicks*5;
        
        List<MineralGroup> groups = new ArrayList<>();
        
        for(int i=0; i<minerals.length && i<maxMinerals; i+=5){
            int dCost = 0;
            int iCost = 0;
            int sCost = 0;
            for(int j=i; j<i+5 && j<minerals.length && j<maxMinerals; j++){
                String mineral = minerals[j];
                if(mineral.equals("diamond")){
                    dCost += 1;
                    iCost += 5;
                    sCost += 25;
                }else if(mineral.equals("iron")){
                    dCost += 1;
                    iCost += 1;
                    sCost += 5;
                }else{
                    dCost += 1;
                    iCost += 1;
                    sCost += 1;
                }
            }
            groups.add(new MineralGroup(dCost, iCost, sCost));
        }
        
        Collections.sort(groups, Comparator.comparingInt((MineralGroup m) -> m.sCost).reversed());
        
        for(MineralGroup group : groups){
            if(picks[0] > 0){
                answer += group.dCost;
                picks[0]--;
            }else if(picks[1] > 0){
                answer += group.iCost;
                picks[1]--;
            }else if(picks[2] > 0){
                answer += group.sCost;
                picks[2]--;
            }
        }
        
        return answer;
    }
}