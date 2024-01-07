import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int[] arr_A, arr_B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr_A = new int[N];
            arr_B = new int[M+1];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr_A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr_B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr_B);

            int ans = 0;
            for(int n=0; n<N; n++) {
                ans += binary_search(arr_B, 1, M, arr_A[n]);
            }
            System.out.println(ans);
        }
    }
    static int binary_search(int[] B, int L, int R, int X) {
        int result = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(B[mid] < X) {
                result = mid;
                L = mid + 1;
            } else if(B[mid] >= X) {
                R = mid - 1;
            }
        }
        return result;
    }

}
