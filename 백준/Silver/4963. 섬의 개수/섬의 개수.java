import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] arr;
    static int[][] dist = {{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    static boolean[][] isVisit;
    static int land_cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            arr = new int[w][h];
            isVisit = new boolean[w][h];
            land_cnt = 0;

            for(int i=0; i<w; i++ ) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<h; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            search();
            sb.append(land_cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        isVisit[x][y] = true;
        for(int i=0; i<8; i++) {
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];
            if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
            if(isVisit[nx][ny] || arr[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }

    static void search() {
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                if(isVisit[i][j] || arr[i][j] == 0) continue;
                land_cnt++;
                dfs(i, j);
            }
        }
    }


}
