import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] arr;
    static boolean[] isVisit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(arr[i]);
        }

        isVisit = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int x) {
        isVisit[x] = true;
        sb.append(x + " ");
        for(int y : arr[x]) {
            if(isVisit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        isVisit = new boolean[N+1];

        queue.add(x);
        isVisit[x] = true;

        while(!queue.isEmpty()) {
            x = queue.poll();
            sb.append(x + " ");
            for(int y : arr[x]) {
                if(isVisit[y]) continue;
                queue.add(y);
                isVisit[y] = true;
            }
        }
    }

}
