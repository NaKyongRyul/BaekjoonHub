import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] isVisit;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        isVisit = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        bfs();
        System.out.println(sb);
    }

    static void dfs(int x) {
        isVisit[x] = true;
        sb.append(x + " ");
        for(int j=1; j<N+1; j++) {
            if(arr[j][x] == 1 && !isVisit[j]) {
                dfs(j);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        isVisit = new boolean[N+1];
        queue.offer(V);
        isVisit[V] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x + " ");
            for(int j=1; j<N+1; j++) {
                if(arr[j][x] == 1 && isVisit[j] == false) {
                    queue.offer(j);
                    isVisit[j] = true;
                }
            }
        }
    }
}
