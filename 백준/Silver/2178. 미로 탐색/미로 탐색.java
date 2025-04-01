import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};;
    static int[][] dist;
    static String[] s;

    static void bfs(int x, int y) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        dist[x][y] = 1;
        visit[x][y] = true;

        while(!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            for(int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(s[nx].charAt(ny) == '0') continue;
                queue.add(nx);
                queue.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        s = new String[N];
        visit = new boolean[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++) {
            s[i] = br.readLine();
        }

        bfs(0,0);
        sb.append(dist[N-1][M-1]);
        System.out.println(sb);
    }
}
