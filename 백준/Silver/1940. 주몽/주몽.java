import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int sum, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start_idx = 0;
        int end_idx = N-1;
        
        while(start_idx < end_idx) {
            if(arr[start_idx] + arr[end_idx] == M) {
                cnt++;
                start_idx++;
                end_idx--;
            } else if(arr[start_idx] + arr[end_idx] > M) {
                end_idx--;
            } else {
                start_idx++;
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}