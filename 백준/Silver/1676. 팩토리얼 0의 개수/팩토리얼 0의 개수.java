import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(n>=5) {
            cnt += n/5;
            n /= 5;
        }

        sb.append(cnt);
        System.out.println(sb);
    }
}