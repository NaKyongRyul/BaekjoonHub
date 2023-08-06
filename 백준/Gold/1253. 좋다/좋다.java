import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int cnt;

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

        for(int i=0; i<N; i++) {
            int start_idx = 0, end_idx = N-1;//1도 생각
            while(start_idx < end_idx) {
                if(arr[start_idx] + arr[end_idx] == arr[i]) {
                    if(start_idx == i) {
                        start_idx++;
                    } else if(end_idx == i) {
                        end_idx--;
                    } else {
                        cnt++;
                        break;
                    }
                } else if(arr[start_idx] + arr[end_idx] < arr[i]) {
                    start_idx++;
                } else {
                    end_idx--;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}