import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int L = Integer.MIN_VALUE, R = 1000000000, ans = 0;
        for(int i=0; i<N; i++) {
            L = Math.max(L, arr[i]);
        }

        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }

    static boolean determination(int K) {
        int sum = 0, cnt = 1;
        for(int i=0; i<N; i++) {
            if(sum + arr[i] <= K ) {
                sum += arr[i];
            } else {
                cnt++;
                sum = arr[i];
            }
        }
        return cnt <= M;
    }

}