import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long L = 1;
        long R = Integer.MAX_VALUE;
        long ans = 0;
        while(L <= R) {
            long mid = (L + R) / 2;
            if(determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }

    static boolean determination(long len) {
        long sum = 0;
        for(int i=0; i<K; i++) {
            sum += arr[i] / len;
        }
        return sum >= N;
    }
}