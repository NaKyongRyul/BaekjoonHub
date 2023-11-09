import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
//        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            arr[i] += arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        if (arr[N] == 0) {
            sb.append("SAD");
            System.out.println(sb);
            return;
        }

        int max = 0;
        int result = 0;
        int count = 0;

        for (int i = X; i <= N; i++) {
            result = arr[i] - arr[i-X];
            if (result > max) {
                max = result;
                count = 1;
            } else if (result == max) {
                count++;
            }
        }
        sb.append(max + "\n" + count);
        System.out.println(sb);
    }
}