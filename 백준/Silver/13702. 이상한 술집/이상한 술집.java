import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long L = 0, R = Integer.MAX_VALUE, ans = 0;
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

    static boolean determination(long ml) {
        long cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= ml) {
                cnt += arr[i] / ml;
            }
        }
        return cnt >= K;
    }

}