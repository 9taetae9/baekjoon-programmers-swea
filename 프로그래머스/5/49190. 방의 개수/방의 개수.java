import java.util.Set;
import java.util.HashSet;

class Solution {

    private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public int solution(int[] arrows) {
        
        int r = 0, c = 0;
        Set<String> nodes = new HashSet<>();
        Set<String> edges = new HashSet<>();
        
        nodes.add(key(r,c));
        
        int room = 0;
        
        for(int arrow : arrows){
            
            for(int step = 0; step < 2; step++){
                int nr = r + dr[arrow];
                int nc = c + dc[arrow];

                String nodeKey = key(nr, nc);
                String edgeKey = edgeKey(r, c, nr, nc);

                if(nodes.contains(nodeKey)){
                    if(!edges.contains(edgeKey)){
                        room++;
                        edges.add(edgeKey);
                    }
                }else{
                    nodes.add(nodeKey);
                    edges.add(edgeKey);
                }
                
                r = nr;
                c = nc;
            }
        }
        
        return room;
    }
    
    private String key(int x, int y){
        return x+","+y; //키: "x,y"
    }
    
    private String edgeKey(int x1, int y1, int x2, int y2){
        if(x1 < x2 || (x1 == x2) && (y1 <= y2)){
            return x1+","+y1+"-"+x2+","+y2;
        }else{
            return x2+","+y2+"-"+x1+","+y1;
        }
        
    }
}

    
    
    