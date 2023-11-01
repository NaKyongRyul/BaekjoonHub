import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        ans = S.length();

        for(int i=0; i<S.length(); i++) {
            if(isPalindrome(S.substring(i))) break;
        }

        sb.append(ans);
        System.out.println(ans);
    }

    static boolean isPalindrome(String s) {
        for(int j=0; j<s.length()/2; j++) {
            if(s.charAt(j) != s.charAt(s.length()-1-j)) {
                ans++;
                return false;
            }
        }
        return true;
    }
}