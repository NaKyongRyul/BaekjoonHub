import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R, cnt;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = Math.min(N, M) / 2;

        for(int i=0; i<R; i++) {
            cycle();
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void cycle() {
        for(int c=0; c<cnt; c++) {
            int x_basic = c;
            int y_basic = c;
            int temp = arr[x_basic][y_basic];

            for(int k=0; k<4; k++) {
                int x = x_basic + dx[k];
                int y = y_basic + dy[k];

                if(x<c || y<c || x>=N-c || y>=M-c) continue;
                arr[x_basic][y_basic] = arr[x][y];
                x_basic = x;
                y_basic = y;
                k -= 1;
            }
            arr[c+1][c] = temp;
        }
    }
}
