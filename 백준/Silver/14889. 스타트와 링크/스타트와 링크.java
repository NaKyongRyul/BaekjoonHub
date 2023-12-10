import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] isVisit;
    static int val;
    static int result = Integer.MAX_VALUE;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        isVisit = new boolean[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        sb.append(result);
        System.out.println(sb);
    }

    static void dfs(int idx, int depth) {
        if(depth == N/2) {
            score();
            return;
        }

        for(int i=idx; i<N; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                dfs(i+1, depth+1);
                isVisit[i] = false;
            }
        }
    }

    static void score() {
        int startTeam = 0;
        int linkTeam = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(isVisit[i] && isVisit[j]) {
                    startTeam += arr[i][j];
                    startTeam += arr[j][i];
                } else if(!isVisit[i] && !isVisit[j]) {
                    linkTeam += arr[i][j];
                    linkTeam += arr[j][i];
                }
            }
        }
        val = Math.abs(startTeam - linkTeam);
        if(val == 0) {
            sb.append(val);
            System.out.println(sb);
            System.exit(0);
        }
        result = Math.min(val, result);
    }
}
