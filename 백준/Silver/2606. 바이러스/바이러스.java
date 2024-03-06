import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, K, ans;
    static ArrayList<Integer>[] arr;
    static boolean[] isVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        isVisit = new boolean[N+1];
        arr = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1);
        sb.append(ans);
        System.out.println(sb);
    }

    static void dfs(int x) {
        isVisit[x] = true;
        for(int i : arr[x]) {
            if(isVisit[i]) continue;
            ans++;
            dfs(i);
        }
    }
}
