import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] arr;
    static long [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] > 0) {
                    int val = arr[i][j];
                    if (val > 0) {
                        if (isValid(i + val)) dp[i + val][j] += dp[i][j];
                        if (isValid(j + val)) dp[i][j + val] += dp[i][j];
                    }
                }
            }
        }
        sb.append(dp[N-1][N-1]);
        System.out.print(sb);
    }
    static boolean isValid(int val) {
        return val < N;
    }
}