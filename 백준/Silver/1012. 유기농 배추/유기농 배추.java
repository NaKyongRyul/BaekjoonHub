import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K;
    static int[][] arr;
    static int[][] dist = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static boolean[][] isVisit;
    static int group_cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            isVisit = new boolean[M][N];
            group_cnt = 0;

            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            search();
            sb.append(group_cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        isVisit[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(isVisit[nx][ny] || arr[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }

    static void search() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(isVisit[i][j] || arr[i][j] == 0) continue;
                group_cnt++;
                dfs(i, j);
            }
        }
    }


}
