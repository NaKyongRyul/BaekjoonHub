import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        sb.append(ans);
        System.out.println(sb);
    }

    static void dfs(int x) {
        if(x>N) return;
        if(ans<x) ans = x;
        for(int i=K-1; i>=0; i--) {
            dfs(x*10+arr[i]);
        }
    }
}