import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static String[] line;
    static int group_cnt;
    static ArrayList<Integer> group;
    static boolean[][] isVisit;
    static int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        isVisit = new boolean[N][N];
        line = new String[N];
        group = new ArrayList<>();

        for(int i=0; i<N; i++) {
            line[i] = br.readLine();
        }

        search();
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for(Integer i : group) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        isVisit[x][y] = true;
        group_cnt++;
        for(int i=0; i<4; i++) {
            int nx = x + dist[i][0];
            int ny = y + dist[i][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(isVisit[nx][ny] || line[nx].charAt(ny) == '0') continue;
            dfs(nx, ny);
        }
    }

    static void search() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(isVisit[i][j] || line[i].charAt(j) == '0') continue;
                group_cnt = 0;
                dfs(i, j);
                group.add(group_cnt);
            }
        }
    }

}
