import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        sb.append(S == 0 ? cnt-1 : cnt);
        System.out.println(sb);
    }

    public static void dfs(int depth, int sum) {
        if(depth == N) {
            if(sum == S) {
                cnt++;
            }
            return;
        }
        dfs(depth+1, sum+arr[depth]);
        dfs(depth+1, sum);
    }
}
