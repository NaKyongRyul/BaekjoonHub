import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int L = 1;
        int R = 1000000000;
        int ans = 0;
        while(L <= R) {
            int mid = (L+R)/2;
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

    public static boolean determination(int distance) {
        int cnt = 1;
        int last = arr[0];
        for(int i=1; i<N; i++) {
            if(arr[i] - last >= distance) {
                cnt++;
                last = arr[i];
            }
        }
        return cnt >= C;
    }


}
