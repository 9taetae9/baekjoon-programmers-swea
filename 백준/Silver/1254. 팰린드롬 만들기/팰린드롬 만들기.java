import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(shortestPalindrome(s));
        sc.close();
    }

    public static int shortestPalindrome(String s){
        if(s.length() <= 1) return 1;
        int max = 1;
        for(int i=0; i<s.length()-1; i++){
            if(isPalindrome(s.substring(i,s.length()))&&s.substring(i,s.length()).length()>max)
                max = s.substring(i,s.length()).length();
        }
        return 2*(s.length() - max) + max;
    }

    public static boolean isPalindrome(String s){
        if (s.isEmpty()) return false;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
}