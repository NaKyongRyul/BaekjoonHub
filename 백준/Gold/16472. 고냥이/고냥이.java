import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, len, ans = Integer.MIN_VALUE;
    static int[] alphabet;
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        word = br.readLine();
        alphabet = new int[26];

        for(int L=0, R=0; R<word.length(); R++) {
            add(word.charAt(R));

            while(true) {
                int kind = 0;
                for(int i=0; i<26; i++) {
                    if(alphabet[i] != 0) {
                        kind++;
                    }
                }
                if(kind <= N) break;
                erase(word.charAt(L));
                L++;
            }

            len = 0;
            for(int i=0; i<26; i++) {
                len += alphabet[i];
            }

            if(ans < len) ans = len;
        }
        sb.append(ans);
        System.out.println(sb);
    }

    static void add(char c) {
        alphabet[c - 'a']++;
    }

    static void erase(char c) {
        alphabet[c - 'a']--;
    }
}
