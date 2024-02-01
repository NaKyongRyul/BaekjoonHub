import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int R = 0, sum = 0, ans = N+1;
        for(int L=1; L<=N; L++) {
            sum -= arr[L-1];
            while(R+1 <= N && sum < S) {
                R++;
                sum += arr[R];
            }
            if(sum >= S) {
                ans = Math.min(ans, R-L+1);
            }
            if(ans == N+1) {
                ans = 0;
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }

}