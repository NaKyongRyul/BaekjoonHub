import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = arr[0], R = N, ans = N;
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

    static boolean determination(int height) {
        int last = 0;
        for(int i=0; i<M; i++) {
            if(arr[i] - last <= height) {
                last = arr[i] + height;
            } else {
                return false;
            }
        }
        return last >= N;
    }

}