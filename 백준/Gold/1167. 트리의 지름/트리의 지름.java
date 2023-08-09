import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Edge>[] list;
    static int max;
    static int node;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int seq = Integer.parseInt(st.nextToken());
            while(true) {
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                list[seq].add(new Edge(node, weight));
            }
        }
        isVisited = new boolean[N+1];
        dfs(1,0);

        isVisited = new boolean[N+1];
        dfs(node, 0);

        sb.append(max);
        System.out.println(sb);
    }

    private static void dfs(int n, int result) {
        if(result > max) {
            max = result;
            node = n;
        }
        isVisited[n] = true;
        for(Edge edge : list[n]) {
            if(!isVisited[edge.n]) {
                dfs(edge.n, edge.w+result);
            }
        }
    }
}

class Edge {
    int n;
    int w;
    Edge(int n, int w) {
        this.n = n;
        this.w = w;
    }
}