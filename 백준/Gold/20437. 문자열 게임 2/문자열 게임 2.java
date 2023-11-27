import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(k == 1) {
                sb.append("1 1" + "\n");
                continue;
            }
            int[] alphabet = new int[26];
            for(int j=0; j<w.length(); j++) {
                alphabet[w.charAt(j)-'a']++;
            }
            int max = -1;
            int min = Integer.MAX_VALUE;
            for(int j=0; j<w.length(); j++) {
                if(alphabet[w.charAt(j)-'a'] < k) continue;
                int cnt = 1;
                for(int n=j+1; n<w.length(); n++) {
                    if(w.charAt(j) == w.charAt(n)) cnt++;
                    if(cnt == k) {
                        min = Math.min(min, n-j+1);
                        max = Math.max(max, n-j+1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) sb.append("-1" + "\n");
            else sb.append(min + " " + max + "\n");
        }
        System.out.println(sb);
    }
}