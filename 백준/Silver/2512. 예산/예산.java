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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int L = 1;
        int R = 100000;
        int ans = 0;

        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                if(mid < arr[N-1]) {
                    ans = mid;
                } else {
                    ans = arr[N-1];
                    break;
                }
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }

    static boolean determination(int mid) {
        long sum = 0;
        for(int i=0; i<N; i++) {
            if(arr[i] <= mid) {
                sum += arr[i];
            } else {
                sum += mid;
            }
        }
        return sum <= M;
    }
}