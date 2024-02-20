import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];

        long ans = 0; // n(n+1)/2인데 n=10만 이므로 50억이다.
        for(int L=0, R=0; L<N; L++) {
            while(R+1 <= N && cnt[arr[R]] == 0) {
                cnt[arr[R]]++;
                R++;
            }
            ans += R-L;
            cnt[arr[L]]--;
        }
        sb.append(ans);
        System.out.println(sb);
    }
}
