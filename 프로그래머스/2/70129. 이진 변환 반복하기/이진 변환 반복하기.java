class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int cnt = 0;
        int zero = 0;
        while (s.length()>1) {
            s = s.replaceAll("0","");
            System.out.println(s);
            zero += len - s.length();
            System.out.println("zero = " + zero);
            s = Integer.toBinaryString(s.length());
            len = s.length();
            System.out.println(s);
            cnt++;
        }
        
        return new int[]{cnt, zero};
    }
}