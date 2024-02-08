import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, N+1);
        int R = 1, ans = Integer.MAX_VALUE;
        for(int L=1; L<=N; L++) {

            while(R+1 <= N && arr[R]-arr[L] < M) {
                R++;
            }

            if(arr[R]-arr[L] >= M) {
                ans = Math.min(arr[R]-arr[L], ans);
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }
}
