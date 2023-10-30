import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int ans = 0;

        if(N<100) {
            ans = N;
            sb.append(ans);
            System.out.println(sb);
            return;
        }

        ans = 99;

        for(int i=100; i<=N; i++) {
           String num = Integer.toString(i);
           if(Character.getNumericValue(num.charAt(0)) - Character.getNumericValue(num.charAt(1)) != Character.getNumericValue(num.charAt(1)) - Character.getNumericValue(num.charAt(2))) continue;
           ans++;
        }
        sb.append(ans);
        System.out.println(sb);
    }
}