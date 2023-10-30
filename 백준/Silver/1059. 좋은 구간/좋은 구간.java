import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        L = Integer.parseInt(br.readLine());
        arr = new int[L];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int ans = 0;

        for(int i=0; i<L; i++) {
            if(arr[i] == n) {
                sb.append(ans);
                System.out.println(sb);
                return;
            }
        }

        int start = 0;
        int end = 0;

        if(arr[0] > n) {
            start = 1;
        }

        for(int i=0; i<L; i++) {
            if(arr[i] < n) {
                start = arr[i] + 1;
            } else {
                end = arr[i] - 1;
                break;
            }
        }
        ans = (n-start+1) * (end-n+1) - 1;
        sb.append(ans);
        System.out.println(sb);
    }
}