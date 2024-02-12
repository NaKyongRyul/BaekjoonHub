import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
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
        Arrays.sort(arr);

        int L = 0, R = N-1, ans = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        while(L < R) {
            int sum = arr[L] + arr[R];
            if(Math.abs(sum) < ans) {
                ans = Math.abs(sum);
                v1 = arr[L];
                v2 = arr[R];
            }
            if(sum > 0) R--;
            else L++;
        }
        sb.append(v1 + " " + v2);
        System.out.println(sb);
    }

}
