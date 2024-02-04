import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[] arr_A, arr_B, arr_all;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr_A = new int[N];
        arr_B = new int[M];
        arr_all = new int[N+M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr_A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arr_B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            arr_all[i] = arr_A[i];
        }

        for(int i=0; i<M; i++) {
            arr_all[i+N] = arr_B[i];
        }

        Arrays.sort(arr_all);

        for(int i : arr_all) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
