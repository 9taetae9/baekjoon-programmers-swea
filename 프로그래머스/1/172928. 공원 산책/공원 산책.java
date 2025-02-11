class Solution {
    public int[] solution(String[] park, String[] routes) {
        int startX = 0, startY = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        return move(startX, startY, park, routes);
    }
    
    private int[] move(int startX, int startY, String[] park, String[] routes) {
        int curX = startX;
        int curY = startY;
        for (String route : routes) {
            String[] parts = route.split(" ");
            char direction = parts[0].charAt(0);
            int dist = Integer.parseInt(parts[1]);
            boolean valid = true;
            
            switch (direction) {
                case 'N':
                    for (int p = 1; p <= dist; p++) {
                        int nextX = curX - p;
                        if (nextX < 0 || park[nextX].charAt(curY) == 'X') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        curX -= dist;
                    }
                    break;
                    
                case 'S':
                    for (int p = 1; p <= dist; p++) {
                        int nextX = curX + p;
                        if (nextX >= park.length || park[nextX].charAt(curY) == 'X') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        curX += dist;
                    }
                    break;
                    
                case 'W':
                    for (int p = 1; p <= dist; p++) {
                        int nextY = curY - p;
                        if (nextY < 0 || park[curX].charAt(nextY) == 'X') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        curY -= dist;
                    }
                    break;
                    
                case 'E':
                    for (int p = 1; p <= dist; p++) {
                        int nextY = curY + p;
                        if (nextY >= park[0].length() || park[curX].charAt(nextY) == 'X') {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        curY += dist;
                    }
                    break;
            }
        }
        return new int[] {curX, curY};
    }
}
