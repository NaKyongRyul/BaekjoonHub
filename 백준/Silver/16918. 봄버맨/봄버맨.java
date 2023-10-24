import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static char[][] arr;
    static int[][] bombTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        bombTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'O') {
                    bombTime[i][j] = 3;
                }
            }
        }

        for(int t=2; t<=N; t++) {
            if(t%2 == 0) three(t);
            else four(t);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void three(int t) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '.') {
                    arr[i][j] = 'O';
                    bombTime[i][j] = t + 3;
                }
            }
        }
    }

    static void four(int t) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombTime[i][j] == t) {
                    arr[i][j] = '.';
                    bombTime[i][j] = 0;
                    for (int a = 0; a < 4; a++) {
                        int x = i + dx[a];
                        int y = j + dy[a];

                        if (x < 0 || y < 0 || x >= R || y >= C) continue;
                        if(bombTime[x][y] != t) {
                            arr[x][y] = '.';
                            bombTime[x][y] = 0;
                        }
                    }
                }
            }
        }
    }
}