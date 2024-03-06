import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] arr;
    static boolean[][] isVisit;
    static int[][] dist = {{-1,0},{1,0},{0,1},{0,-1}};
    static int wolf, lamb;
    static int current_wolf, current_lamb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        isVisit = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        search();
        sb.append(lamb).append(" ").append(wolf);
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        isVisit[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(isVisit[nx][ny] || arr[nx][ny] == '#') continue;
            if(arr[nx][ny] == 'o') current_lamb++;
            else if(arr[nx][ny] == 'v') current_wolf++;
            dfs(nx, ny);
        }
    }

    static void search() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(isVisit[i][j] || arr[i][j] == '#') continue;
                if(arr[i][j] == 'o') current_lamb++;
                else if(arr[i][j] == 'v') current_wolf++;
                dfs(i, j);
                if(current_lamb > current_wolf) lamb += current_lamb;
                else wolf += current_wolf;
                current_lamb = 0;
                current_wolf = 0;
            }
        }
    }
}
