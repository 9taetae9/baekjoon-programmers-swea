class Solution {
    public int solution(String[] board) {
        int countO = 0;
        int countX = 0;
        boolean oWin = false, xWin = false;
        
        for(String line : board){
            if(line.equals("OOO")) oWin = true;
            else if(line.equals("XXX")) xWin = true;
        }
        for(int i=0; i<3; i++){
            int cntO = 0, cntX = 0;
            
            for(int j=0; j<3; j++){
                if(board[j].charAt(i) == 'O') cntO++;
                else if(board[j].charAt(i) == 'X') cntX++;
            }
            if(cntO == 3){
                oWin = true;
            }else if(cntX == 3){
                xWin = true;
            }
            countO += cntO;
            countX += cntX;
        }
        
        int cntO = 0, cntX = 0;
        for(int i=0; i<3; i++){
            if(board[i].charAt(i) == 'O') cntO++;
            else if(board[i].charAt(i) == 'X') cntX++;
        }
        if(cntO == 3){
            oWin = true;
        }else if(cntX == 3){
            xWin = true;
        }
        cntO = 0;
        cntX = 0;
        for(int i=0; i<3; i++){
            if(board[i].charAt(2-i) == 'O') cntO++;
            else if(board[i].charAt(2-i) == 'X') cntX++;
        }
        if(cntO == 3){
            oWin = true;
        }else if(cntX == 3){
            xWin = true;
        }
        
        if(countO > countX + 1 || countX > countO){
            return 0;
        }
        if(oWin && xWin) return 0;
        if(oWin && countO != countX+1) return 0;
        if(xWin && countO != countX) return 0;
        
        
        return 1;
    }
}

/**
1. X가 1개 이상 많은 경우
2. O가 2개 이상 많은 경우
3. O가 승리한 경우 (O가 1개 더 많음)
4. X가 승리한 경우 (O,X 개수 동일)

*/