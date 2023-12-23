import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] praise;
    static List<Integer>[] child;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        praise = new int[N+1];
        child = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            child[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int par = Integer.parseInt(st.nextToken());
            if(par == -1) continue;
            child[par].add(i);
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            praise[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        dfs(1);
        for(int i=1; i<=N; i++) {
            sb.append(praise[i] + " ");
        }
        System.out.println(sb);
    }

    static void dfs(int x) {
        for(int y : child[x]) {
            praise[y] += praise[x];
            dfs(y);
        }
    }
}