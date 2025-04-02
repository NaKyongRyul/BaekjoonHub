import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static StringBuilder sb;

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(" ");

        for(int y : adj[x]) {
            if(visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visit = new boolean[N+1];
        visit[start] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");

            for(int y : adj[x]) {
                if(visit[y]) continue;
                queue.add(y);
                visit[y] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(adj[i]);
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
}
