import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr_T;
    static int[] arr_P;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr_T = new int[N+1];
        arr_P = new int[N+1];
        dp = new int[N+2];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            arr_T[i] = Integer.parseInt(st.nextToken());//일 수
            arr_P[i] = Integer.parseInt(st.nextToken());//금액
        }

        for(int i=N; i>0; i--) {
            if(i+arr_T[i] > N+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[i+arr_T[i]]+arr_P[i]);
            }
        }
        sb.append(dp[1]);
        System.out.println(sb);
    }
}