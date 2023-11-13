import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] arr;
    static int max, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        if(arr[N] == 0) {
            sb.append("SAD");
            System.out.println(sb);
            return;
        }

        for(int i=0; i<N-X+1; i++) {
            if(arr[X+i] - arr[i] > max) {
                max = arr[X+i] - arr[i];
                cnt = 1;
            } else if(arr[X+i] - arr[i] == max) {
                cnt++;
            }
        }
        sb.append(max + "\n" + cnt);
        System.out.println(sb);
    }
}
