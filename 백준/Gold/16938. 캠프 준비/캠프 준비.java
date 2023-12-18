import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R, X, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        sb.append(ans);
        System.out.println(sb);
    }

    static void dfs(int depth, int cnt, int sum, int max, int min) {
        if(cnt >= 2 && sum >= L && sum <= R && max - min >= X) {
            ans += 1;
        }

        for(int i=depth; i<N; i++) {
            dfs(i+1, cnt+1, sum+arr[i], Math.max(arr[i], max), Math.min(arr[i], min));
        }
    }

}
