import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=1; i<=K; i++) {
            sum += arr[i];
        }

        int ans = sum;

        int end = N-K;
        for(int L=1; L<=end; L++) {
            sum -= arr[L];
            sum += arr[K+L];

            ans = Math.max(sum, ans);
        }
        sb.append(ans);
        System.out.println(sb);
    }

}