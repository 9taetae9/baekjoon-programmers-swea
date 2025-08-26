import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        
        int n = expressions.length;
        
        String[] A = new String[n];
        String[] op = new String[n];
        String[] B = new String[n];
        String[] C = new String[n];
        List<Integer> xIndices = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            String[] part = expressions[i].split(" ");
            A[i] = part[0];
            op[i] = part[1];
            B[i] = part[2];
            C[i] = part[4];
            if(C[i].equals("X")) xIndices.add(i);
        }
        
        List<Integer> candidateBases = new ArrayList<>();
        
        baseLoop:
        for(int base = 2; base<=9; base++){
            // 모든 숫자 A, B, C(숫자인 경우)의 해당 진법 유효성 체크 
            for(int i=0; i<n; i++){
                if(!isValidInBase(A[i], base)) continue baseLoop;
                if(!isValidInBase(B[i], base)) continue baseLoop;
                if(!C[i].equals("X") && !isValidInBase(C[i], base)) continue baseLoop;
            }
            
            // C가 숫자인 식들에 대해 연산 결과가 일치하는지 확인
            for(int i=0; i<n; i++){
                if(C[i].equals("X")) continue;
                int aVal = parseInBase(A[i], base);
                int bVal = parseInBase(B[i], base);
                int cVal = parseInBase(C[i], base);
                int res = op[i].equals("+") ? aVal + bVal : aVal - bVal;
                if(cVal != res) continue baseLoop;
            }
            
            candidateBases.add(base);
        }
        
        List<String> resultList = new ArrayList<>();
        for(int idx : xIndices){
            Set<String> results = new HashSet<>();
            for(int base : candidateBases){
                int aVal = parseInBase(A[idx], base);
                int bVal = parseInBase(B[idx], base);
                int resVal = op[idx].equals("+") ? (aVal + bVal) : (aVal - bVal);
                String repr = toBaseString(resVal, base);
                results.add(repr);
            }
            String fill;
            if(results.size() == 1) fill = results.iterator().next();
            else fill = "?";
            String filledExpr = A[idx] + " " + op[idx] + " " + B[idx] + " = " + fill;
            resultList.add(filledExpr);
        }
        return resultList.toArray(new String[0]);
    }
    
    private boolean isValidInBase(String s, int base){
        for(char c : s.toCharArray()){
            if(c < '0' || c > '9') return false;
            if(c - '0' >= base) return false;
        }
        
        return true;
    }
    
    private int parseInBase(String s, int base){
        int val = 0;
        for(char c : s.toCharArray()){
            int d = c - '0';
            val = val * base + d;
        }
        
        return val;
    }
    
    private String toBaseString(int val, int base){
        if(val == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        while(val > 0){
            sb.append(val%base);
            val/=base;
        }
        
        return sb.reverse().toString();
    }
}