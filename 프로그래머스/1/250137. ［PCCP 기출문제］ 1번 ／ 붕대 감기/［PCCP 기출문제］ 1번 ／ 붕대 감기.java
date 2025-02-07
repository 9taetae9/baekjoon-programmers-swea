class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int Hp = health;
        int answer = 0;
        int set = bandage[0];
        int heal = bandage[1];
        int bonus = bandage[2]; 
        
        int pastT = 0;
        for(int i=0; i<attacks.length; i++){
            int curT = attacks[i][0];
            
            int healTime = curT - pastT - 1;
            int gain = (healTime/set)*bonus + healTime * heal;
            Hp = Math.min(Hp + gain, health); //업데이트
            
            Hp -= attacks[i][1];
            if(Hp <= 0) return -1;
            
            
            pastT = curT;
        }
        
        
        return Hp;
    }
}