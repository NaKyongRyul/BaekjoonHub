import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        int R = 0, sum = 0, ans = N+1;
        for(int L=1; L<=N; L++) {
            while(R+1 <= N && sum < K) {
                R++;
                if(arr[R] == 1) sum++;
            }
            if(sum == K) {
                ans = Math.min(R-L+1, ans);
            }
            if(arr[L] == 1) sum--;
        }
        if(ans == N+1) ans = -1;
        sb.append(ans);
        System.out.println(sb);
    }
}